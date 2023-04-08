package fr.iut.androidproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.iut.androidproject.R
import fr.iut.androidproject.StubFakeData.StubFakeData
import fr.iut.androidproject.model.Category
import fr.iut.androidproject.network.RecetteApi
import fr.iut.androidproject.view.adapter.AdapterCategorys
import fr.iut.androidproject.view.adapter.AdapterRecommended
import kotlinx.coroutines.launch

class FragmentPrincipal : Fragment() {

    private val stubFakeData = StubFakeData()

    private var recommended = mutableListOf<fr.iut.androidproject.model.Recette>() //Pour utiliser l'api il faut utiliser cette ligne
    private var categories = mutableListOf<fr.iut.androidproject.model.Category>() //Pour utiliser l'api il faut utiliser cette ligne

    //private var recommended = stubFakeData.chargeRecommended() //UTILISE DES FAUSSES DONNEES CAR L'API NE FONCTIONNE PLUS
    //private var categories = stubFakeData.chargeCategories() //UTILISE DES FAUSSES DONNEES CAR L'API NE FONCTIONNE PLUS

    private val _status = MutableLiveData<String>()

    private lateinit var adapterRecommended: AdapterRecommended
    private lateinit var adpterCategorys: AdapterCategorys

    private lateinit var recommendedList: RecyclerView
    private lateinit var categoryList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        adapterRecommended = AdapterRecommended(recommended)
        adpterCategorys = AdapterCategorys(categories)


        getCategorys() //Pour utiliser l'api il faut utiliser cette ligne
        getRecommended() //Pour utiliser l'api il faut utiliser cette ligne
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        recommendedList = rootView.findViewById(R.id.recommended)
        recommendedList.adapter = adapterRecommended
        recommendedList.layoutManager = LinearLayoutManager(context)

        categoryList = rootView.findViewById(R.id.categoryList)
        categoryList.adapter = adpterCategorys
        categoryList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        return rootView
    }

    private fun transformListIngredients() : MutableList<String>{
        val listIngredients = mutableListOf<String>()
        lifecycleScope.launch {
            try {
                val listResult = RecetteApi.retrofitService.getRecommended()
                for (recette in listResult.meals) {
                    if (recette.strIngredient1?.isNotEmpty() == true && recette.strIngredient1.isNotBlank()) listIngredients.add(recette.strIngredient1)
                    if (recette.strIngredient2?.isNotEmpty() == true && recette.strIngredient2.isNotBlank()) listIngredients.add(recette.strIngredient2)
                    if (recette.strIngredient3?.isNotEmpty() == true && recette.strIngredient3.isNotBlank()) listIngredients.add(recette.strIngredient3)
                    if (recette.strIngredient4?.isNotEmpty() == true && recette.strIngredient4.isNotBlank()) listIngredients.add(recette.strIngredient4)
                    if (recette.strIngredient5?.isNotEmpty() == true && recette.strIngredient5.isNotBlank()) listIngredients.add(recette.strIngredient5)
                    if (recette.strIngredient6?.isNotEmpty() == true && recette.strIngredient6.isNotBlank()) listIngredients.add(recette.strIngredient6)
                    if (recette.strIngredient7?.isNotEmpty() == true && recette.strIngredient7.isNotBlank()) listIngredients.add(recette.strIngredient7)
                    if (recette.strIngredient8?.isNotEmpty() == true && recette.strIngredient8.isNotBlank()) listIngredients.add(recette.strIngredient8)
                    if (recette.strIngredient9?.isNotEmpty() == true && recette.strIngredient9.isNotBlank()) listIngredients.add(recette.strIngredient9)
                    if (recette.strIngredient10?.isNotEmpty() == true && recette.strIngredient10.isNotBlank()) listIngredients.add(recette.strIngredient10)
                    if (recette.strIngredient11?.isNotEmpty() == true && recette.strIngredient11.isNotBlank()) listIngredients.add(recette.strIngredient11)
                    if (recette.strIngredient12?.isNotEmpty() == true && recette.strIngredient12.isNotBlank()) listIngredients.add(recette.strIngredient12)
                    if (recette.strIngredient13?.isNotEmpty() == true && recette.strIngredient13.isNotBlank()) listIngredients.add(recette.strIngredient13)
                    if (recette.strIngredient14?.isNotEmpty() == true && recette.strIngredient14.isNotBlank()) listIngredients.add(recette.strIngredient14)
                    if (recette.strIngredient15?.isNotEmpty() == true && recette.strIngredient15.isNotBlank()) listIngredients.add(recette.strIngredient15)
                    if (recette.strIngredient16?.isNotEmpty() == true && recette.strIngredient16.isNotBlank()) listIngredients.add(recette.strIngredient16)
                    if (recette.strIngredient17?.isNotEmpty() == true && recette.strIngredient17.isNotBlank()) listIngredients.add(recette.strIngredient17)
                    if (recette.strIngredient18?.isNotEmpty() == true && recette.strIngredient18.isNotBlank()) listIngredients.add(recette.strIngredient18)
                    if (recette.strIngredient19?.isNotEmpty() == true && recette.strIngredient19.isNotBlank()) listIngredients.add(recette.strIngredient19)
                    if (recette.strIngredient20?.isNotEmpty() == true && recette.strIngredient20.isNotBlank()) listIngredients.add(recette.strIngredient20)

                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }

        }
        return listIngredients
    }

    private fun transformListMeasures() : MutableList<String>{
        val listMeasures = mutableListOf<String>()
        lifecycleScope.launch {
            try {
                val listResult = RecetteApi.retrofitService.getRecommended()
                for (recette in listResult.meals) {
                    if(recette.strMeasure1?.isNotEmpty() == true && recette.strMeasure1.isNotBlank()) listMeasures.add(recette.strMeasure1)
                    if(recette.strMeasure2?.isNotEmpty() == true && recette.strMeasure2.isNotBlank()) listMeasures.add(recette.strMeasure2)
                    if(recette.strMeasure3?.isNotEmpty() == true && recette.strMeasure3.isNotBlank()) listMeasures.add(recette.strMeasure3)
                    if(recette.strMeasure4?.isNotEmpty() == true && recette.strMeasure4.isNotBlank()) listMeasures.add(recette.strMeasure4)
                    if(recette.strMeasure5?.isNotEmpty() == true && recette.strMeasure5.isNotBlank()) listMeasures.add(recette.strMeasure5)
                    if(recette.strMeasure6?.isNotEmpty() == true && recette.strMeasure6.isNotBlank()) listMeasures.add(recette.strMeasure6)
                    if(recette.strMeasure7?.isNotEmpty() == true && recette.strMeasure7.isNotBlank()) listMeasures.add(recette.strMeasure7)
                    if(recette.strMeasure8?.isNotEmpty() == true && recette.strMeasure8.isNotBlank()) listMeasures.add(recette.strMeasure8)
                    if(recette.strMeasure9?.isNotEmpty() == true && recette.strMeasure9.isNotBlank()) listMeasures.add(recette.strMeasure9)
                    if(recette.strMeasure10?.isNotEmpty() == true && recette.strMeasure10.isNotBlank()) listMeasures.add(recette.strMeasure10)
                    if(recette.strMeasure11?.isNotEmpty() == true && recette.strMeasure11.isNotBlank()) listMeasures.add(recette.strMeasure11)
                    if(recette.strMeasure12?.isNotEmpty() == true && recette.strMeasure12.isNotBlank()) listMeasures.add(recette.strMeasure12)
                    if(recette.strMeasure13?.isNotEmpty() == true && recette.strMeasure13.isNotBlank()) listMeasures.add(recette.strMeasure13)
                    if(recette.strMeasure14?.isNotEmpty() == true && recette.strMeasure14.isNotBlank()) listMeasures.add(recette.strMeasure14)
                    if(recette.strMeasure15?.isNotEmpty() == true && recette.strMeasure15.isNotBlank()) listMeasures.add(recette.strMeasure15)
                    if(recette.strMeasure16?.isNotEmpty() == true && recette.strMeasure16.isNotBlank()) listMeasures.add(recette.strMeasure16)
                    if(recette.strMeasure17?.isNotEmpty() == true && recette.strMeasure17.isNotBlank()) listMeasures.add(recette.strMeasure17)
                    if(recette.strMeasure18?.isNotEmpty() == true && recette.strMeasure18.isNotBlank()) listMeasures.add(recette.strMeasure18)
                    if(recette.strMeasure19?.isNotEmpty() == true && recette.strMeasure19.isNotBlank()) listMeasures.add(recette.strMeasure19)
                    if(recette.strMeasure20?.isNotEmpty() == true && recette.strMeasure20.isNotBlank()) listMeasures.add(recette.strMeasure20)



                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }

        }
        return listMeasures
    }

    private fun getRecommended() {
        lifecycleScope.launch {
            try {
                val listResult = RecetteApi.retrofitService.getRecommended()
                val listIngredients : MutableList<String> = transformListIngredients()
                val listMeasures : MutableList<String> = transformListMeasures()

                _status.value = "Success: ${listResult.meals.size} C'est bon"
                recommended.addAll(recommended)
                adapterRecommended.updateList(listResult.meals.map {
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

    /*
    private fun getRecettes() {
        lifecycleScope.launch {
            try {
                val listResult = RecetteApi.retrofitService.getRecettes()
                _status.value = "Success: ${listResult.meals.size} C'est bon"
                recettes.addAll(recettes)
                adapterMeals.updateList(listResult.meals.map {
                    fr.iut.androidproject.model.Recette(
                        it.idMeal,
                        it.strMeal,
                        it.strInstructions,
                        it.strMealThumb,
                    )
                })
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
     */

    private fun getCategorys() {
        lifecycleScope.launch {
            try {
                val listResult = RecetteApi.retrofitService.getCategories()
                _status.value = "Success: ${listResult.categories.size} C'est bon"
                categories.addAll(categories)
                adpterCategorys.updateList(listResult.categories.map {
                    fr.iut.androidproject.model.Category(
                        it.idCategory,
                        it.strCategory,
                        it.strCategoryThumb
                    )
                })
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }

}

