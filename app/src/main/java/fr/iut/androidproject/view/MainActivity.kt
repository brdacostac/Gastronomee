package fr.iut.androidproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import fr.iut.androidproject.R
import fr.iut.androidproject.network.Recette
import fr.iut.androidproject.network.RecetteApi

import fr.iut.androidproject.view.adapter.MonAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        //adapter = MonAdapter(emptyList())
        //findViewById<RecyclerView>(R.id.mealList).adapter = adapter
        //findViewById<RecyclerView>(R.id.mealList).layoutManager = LinearLayoutManager(this)
        //AndroidNetworking.initialize(getApplicationContext());
        //getRecettes()
    }

}