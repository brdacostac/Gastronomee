package fr.iut.androidproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.iut.androidproject.R
import fr.iut.androidproject.StubFakeData.StubFakeData
import fr.iut.androidproject.network.RecetteApi
import fr.iut.androidproject.view.adapter.AdapterCategorys
import fr.iut.androidproject.view.adapter.AdapterMeals
import fr.iut.androidproject.view.adapter.AdapterRecommended
import kotlinx.coroutines.launch


class FragmentAllMealsCategory : Fragment() {

    private val _status = MutableLiveData<String>()
    private var mealsByCategory = mutableListOf<fr.iut.androidproject.model.Recette>()

    private val stubFakeData = StubFakeData()

    private lateinit var mealsList: RecyclerView

    private lateinit var adapterMeals: AdapterMeals

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val strCategoryId = arguments?.getString("strCategoryId")
        val strCategory = arguments?.getString("strCategory")

        //mealsByCategory = stubFakeData.getMealsByCategory(strCategory.toString()) // Utilise des fake données car l'api ne marche pas

        adapterMeals = AdapterMeals(mealsByCategory)

        getMeals(strCategory.toString()) // Utilise l'api pour récupérer les données
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val strCategoryThumb = arguments?.getString("strCategoryThumb")

        val ImageCategoryThumb: ImageView = view.findViewById(R.id.categoryImage)
        Picasso.get().load("$strCategoryThumb").into(ImageCategoryThumb)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_all_meals_category, container, false)
        mealsList  = rootView.findViewById(R.id.mealsListByCategoryy)
        mealsList.adapter = adapterMeals
        mealsList.layoutManager = GridLayoutManager(context, 3)
        return rootView
    }

    //J'explique cette methode, en fait dans mon API, la requete de getAllMealsByCategory m'envoie pas tout les details de la recette
    // seulement l'id, le nom, l'image et la category, j'ai donc du de recuperer cette id et mettre dans une autre requete
    // le getMealById pour recuperer les details de la recette et l'afficher quand l'utilisateur clique sur une recette
    // car si je faisais pas ça, j'aurais pas pu afficher les details de la recette comme le recipe, area, ingredients, etc...

    //En resume cette methode va transformer une liste de recette avec seulement l'id, le nom, l'image et la category
    // en une liste de recette avec tous les details de la recette

    private fun getMeals(categoryName: String) {
        lifecycleScope.launch {
            try {
                val listMealsCategory = RecetteApi.retrofitService.getMealsByCategory(categoryName)
                val mealsNotRecommended = true;

                _status.value = "Success: ${listMealsCategory.meals.size} C'est bon"
                mealsByCategory.addAll(mealsByCategory)

                listMealsCategory.meals.iterator().forEach {
                    val listResult = RecetteApi.retrofitService.getMealById(it.idMeal)
                    mealsByCategory.addAll(mealsByCategory)
                    val listIngredients : MutableList<String> = FragmentPrincipal().transformListIngredients(it.idMeal)
                    val listMeasures : MutableList<String> = FragmentPrincipal().transformListMeasures(it.idMeal)
                    adapterMeals.updateAddList(listResult.meals.map {
                        fr.iut.androidproject.model.Recette(
                            it.idMeal,
                            it.strMeal,
                            it.strInstructions,
                            it.strMealThumb,
                            it.strArea,
                            it.strCategory,
                            listIngredients,
                            listMeasures
                        )
                    })
                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }

}