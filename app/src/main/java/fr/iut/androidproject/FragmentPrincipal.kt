package fr.iut.androidproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.iut.androidproject.network.RecetteApi
import fr.iut.androidproject.view.adapter.AdapterCategorys
import fr.iut.androidproject.view.adapter.AdapterMeals
import kotlinx.coroutines.launch

class FragmentPrincipal : Fragment() {

    private var recettes = mutableListOf<fr.iut.androidproject.model.Recette>()
    private var categories = mutableListOf<fr.iut.androidproject.model.Category>()

    private val _status = MutableLiveData<String>()

    private lateinit var adapterMeals: AdapterMeals
    private lateinit var adpterCategorys: AdapterCategorys

    private lateinit var mealList: RecyclerView
    private lateinit var categoryList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapterMeals = AdapterMeals(recettes)
        adpterCategorys = AdapterCategorys(categories)
        getRecettes()
        getCategorys()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        mealList = rootView.findViewById(R.id.mealList)
        mealList.adapter = adapterMeals
        mealList.layoutManager = LinearLayoutManager(context)

        categoryList = rootView.findViewById(R.id.categoryList)
        categoryList.adapter = adpterCategorys
        categoryList.layoutManager = LinearLayoutManager(context)

        return rootView
    }

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

