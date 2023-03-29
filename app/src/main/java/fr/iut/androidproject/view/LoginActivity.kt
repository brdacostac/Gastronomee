package fr.iut.androidproject.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import fr.iut.androidproject.R
import fr.iut.androidproject.dao.UserDao
import fr.iut.androidproject.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var userDao: UserDao
    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userDao = AppDatabase.getInstance(this).userDao()

        val usernameInput = findViewById<EditText>(R.id.username_input)
        val passwordInput = findViewById<EditText>(R.id.password_input)
        val loginButton = findViewById<Button>(R.id.button)

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()
            } else {
                viewModelScope.launch {
                    val user = userDao.getUserByUsernameAndPassword(username, password)
                    if (user != null) {
                        Toast.makeText(this@LoginActivity, "Connexion réussie!", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this@LoginActivity, ProfileActivity::class.java).apply {
                            putExtra("USER_ID", user.id)
                            putExtra("USER_FULLNAME", user.fullname)
                            putExtra("USER_USERNAME", user.username)
                            putExtra("USER_PASSWORD", user.password)
                        }

                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this@LoginActivity, "Nom d'utilisateur ou mot de passe incorrect", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
