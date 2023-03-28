package fr.iut.androidproject.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import fr.iut.androidproject.R
import fr.iut.androidproject.UserDao
import fr.iut.androidproject.database.AppDatabase
import fr.iut.androidproject.entity.EntityUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val userFullname = intent.getStringExtra("USER_FULLNAME")
        val userUsername = intent.getStringExtra("USER_USERNAME")
        val userPassword = intent.getStringExtra("USER_PASSWORD")

        val fullnameTextView = findViewById<TextView>(R.id.fullnameTextView)
        val usernameTextView = findViewById<TextView>(R.id.usernameTextView)
        val passwordTextView = findViewById<TextView>(R.id.passwordTextView)

        fullnameTextView.text = "Full Name: $userFullname"
        usernameTextView.text = "Username: $userUsername"
        passwordTextView.text = "Password: $userPassword"
    }
}
