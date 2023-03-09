package fr.iut.androidproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import fr.iut.androidproject.R
import fr.iut.androidproject.stub.RecetteAPI
import fr.iut.androidproject.view.adapter.MonAdapter

class MainActivity : AppCompatActivity() {

    var stub = RecetteAPI().getRecettes("Arrabiata")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        findViewById<RecyclerView>(R.id.mealList).adapter = MonAdapter(stub)
        findViewById<RecyclerView>(R.id.mealList).layoutManager = lay
    }
}