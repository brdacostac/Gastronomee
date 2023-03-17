package fr.iut.androidproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.iut.androidproject.R
import fr.iut.androidproject.network.RecetteApi
import fr.iut.androidproject.network.RecetteApiService
import fr.iut.androidproject.stub.RecetteAPI
import fr.iut.androidproject.view.adapter.MonAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private var stub = getRecettes()
    //private var stub = RecetteAPI().load()
    private val _status = MutableLiveData<String>()

    private fun getRecettes() {
        lifecycleScope.launch {
            try {
                val listResult = RecetteApi.retrofitService.getRecettes()
                _status.value = "Success: ${listResult.size} C'est bon"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onResume() {
        super.onResume()
        //findViewById<RecyclerView>(R.id.mealList).adapter = MonAdapter(stub)
        findViewById<RecyclerView>(R.id.mealList).layoutManager = LinearLayoutManager(this)
    }
}