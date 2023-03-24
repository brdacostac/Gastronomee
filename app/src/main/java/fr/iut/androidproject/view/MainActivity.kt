package fr.iut.androidproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.iut.androidproject.R
import fr.iut.androidproject.network.Recette
import fr.iut.androidproject.network.RecetteApi

import fr.iut.androidproject.view.adapter.MonAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var recettes = mutableListOf<Recette>()
    private val _status = MutableLiveData<String>()
    private lateinit var adapter: MonAdapter

    private fun getRecettes() {
        lifecycleScope.launch {
            try {
                val listResult = RecetteApi.retrofitService.getRecettes()
                _status.value = "Success: ${listResult.size} C'est bon"
                recettes.addAll(listResult)
                adapter.updateList(recettes.map {
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


    /*
    private val categories: Unit
        private get() {
            AndroidNetworking.get(Api.Categories)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject) {
                        try {
                            progressDialog!!.dismiss()
                            val playerArray = response.getJSONArray("categories")
                            for (i in 0 until playerArray.length()) {

                                val temp = playerArray.getJSONObject(i)
                                val dataApi = ModelMain()
                                dataApi.strCategory = temp.getString("strCategory")
                                dataApi.strCategoryThumb = temp.getString("strCategoryThumb")
                                dataApi.strCategoryDescription = temp.getString("strCategoryDescription")
                                modelMain.add(dataApi)
                                showCategories()
                            }
                        } catch (e: JSONException) {
                            e.printStackTrace()
                            Toast.makeText(this@MainActivity,
                                "Gagal menampilkan data!", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onError(anError: ANError) {
                        progressDialog!!.dismiss()
                        Toast.makeText(this@MainActivity, "No internet connection!", Toast.LENGTH_SHORT).show()
                    }
                })
        }

     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = MonAdapter(emptyList())
        //findViewById<RecyclerView>(R.id.mealList).adapter = adapter
        //findViewById<RecyclerView>(R.id.mealList).layoutManager = LinearLayoutManager(this)
        //AndroidNetworking.initialize(getApplicationContext());
        getRecettes()
    }

}