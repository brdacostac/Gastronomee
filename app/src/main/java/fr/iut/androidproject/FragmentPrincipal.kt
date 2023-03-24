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
import fr.iut.androidproject.network.Recette
import fr.iut.androidproject.network.RecetteApi
import fr.iut.androidproject.view.adapter.MonAdapter
import kotlinx.coroutines.launch

class FragmentPrincipal : Fragment() {

    private var recettes = mutableListOf<fr.iut.androidproject.model.Recette>()
    private val _status = MutableLiveData<String>()
    private lateinit var adapter: MonAdapter
    private lateinit var mealList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = MonAdapter(recettes)
        getRecettes()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        mealList = rootView.findViewById(R.id.mealList)
        mealList.adapter = adapter
        mealList.layoutManager = LinearLayoutManager(context)
        return rootView
    }

    private fun getRecettes() {
        lifecycleScope.launch {
            try {
                val listResult = RecetteApi.retrofitService.getRecettes()
                _status.value = "Success: ${listResult.meals.size} C'est bon"
                recettes.addAll(recettes)
                adapter.updateList(listResult.meals.map {
                    fr.iut.androidproject.model.Recette(
                        it.idMeal,
                        it.strMeal,
                        it.strInstructions
                    )
                })
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }

}

