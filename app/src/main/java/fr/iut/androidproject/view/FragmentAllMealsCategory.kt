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

    private fun getMeals(categoryName: String) {
        lifecycleScope.launch {
            try {
                val listResult = RecetteApi.retrofitService.getMealsByCategory(categoryName)

                _status.value = "Success: ${listResult.meals.size} C'est bon"
                mealsByCategory.addAll(mealsByCategory)
                adapterMeals.updateList(listResult.meals.map {
                    val listIngredients = mutableListOf<String>() //CHANGER ça
                    val listMeasures = mutableListOf<String>() //CHANGER ça
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
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }

}