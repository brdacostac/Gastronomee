package fr.iut.androidproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.iut.androidproject.R

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
    }

}