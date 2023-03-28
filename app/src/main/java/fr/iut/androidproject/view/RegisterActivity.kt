package fr.iut.androidproject.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.iut.androidproject.R
import fr.iut.androidproject.UserDao
import fr.iut.androidproject.database.AppDatabase
import fr.iut.androidproject.entity.EntityUser
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log

class RegisterActivity : AppCompatActivity() {

    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        userDao = AppDatabase.getInstance(this).userDao()

        val fullnameInput = findViewById<EditText>(R.id.fullname_input)
        val usernameInput = findViewById<EditText>(R.id.username_input)
        val passwordInput = findViewById<EditText>(R.id.password_input)
        val registerButton = findViewById<Button>(R.id.register_button)

        registerButton.setOnClickListener {
            val fullname = fullnameInput.text.toString()
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (fullname.isEmpty() || username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()
            } else {
                val entityUser = EntityUser(fullname = fullname, username = username, password = password)
                GlobalScope.launch {
                    userDao.insertUser(entityUser)
                }
                Toast.makeText(this, "Compte créé avec succès!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}