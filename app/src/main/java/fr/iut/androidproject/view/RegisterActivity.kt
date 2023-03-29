package fr.iut.androidproject.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.iut.androidproject.R
import fr.iut.androidproject.dao.UserDao
import fr.iut.androidproject.database.AppDatabase
import fr.iut.androidproject.entity.EntityUser
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

            var isValid = true

            if (fullname.isEmpty()) {
                fullnameInput.error = "Please enter your fullname"
                isValid = false
            } else if (fullname.length > 30) {
                fullnameInput.error = "Fullname cannot exceed 30 characters"
                isValid = false
            }

            if (username.isEmpty()) {
                usernameInput.error = "Please enter your username"
                isValid = false
            } else if (username.length > 10) {
                usernameInput.error = "Username cannot exceed 10 characters"
                isValid = false
            }

            if (password.isEmpty()) {
                passwordInput.error = "Please enter your password"
                isValid = false
            } else if (password.length < 2) {
                passwordInput.error = "Password must be at least 2 characters long"
                isValid = false
            }

            if (isValid) {
                GlobalScope.launch {
                    val user = userDao.getUserByUsername(username)
                    if (user == null) {
                        val entityUser = EntityUser(fullname = fullname, username = username, password = password)
                        userDao.insertUser(entityUser)
                        runOnUiThread {
                            Toast.makeText(this@RegisterActivity, "Account created successfully!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                            startActivity(intent)
                        }
                    } else {
                        runOnUiThread {
                            usernameInput.error = "This username is already taken"
                        }
                    }
                }
            }
        }
    }
}