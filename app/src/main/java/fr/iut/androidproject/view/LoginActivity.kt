package fr.iut.androidproject.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import fr.iut.androidproject.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton = findViewById<Button>(R.id.button)

        loginButton.setOnClickListener {
            val intent = Intent(this, PresentationRecetteActivity::class.java)
            PresentationRecetteActivity()
        }
    }
}