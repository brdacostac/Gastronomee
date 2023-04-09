package fr.iut.androidproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import fr.iut.androidproject.R
import fr.iut.androidproject.dao.UserDao
import fr.iut.androidproject.database.AppDatabase
import fr.iut.androidproject.entity.EntityUser
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class FragmentRegister : Fragment() {

    private lateinit var userDao: UserDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userDao = AppDatabase.getInstance(requireContext()).userDao()

        val fullnameInput = view.findViewById<EditText>(R.id.fullname_input)
        val usernameInput = view.findViewById<EditText>(R.id.username_input)
        val passwordInput = view.findViewById<EditText>(R.id.password_input)
        val registerButton = view.findViewById<View>(R.id.registerButton)

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
                lifecycleScope.launch {
                    val user = userDao.getUserByUsername(username)
                    if (user == null) {
                        val entityUser = EntityUser(fullname = fullname, username = username, password = password)
                        userDao.insertUser(entityUser)
                        Toast.makeText(requireContext(), "Account created successfully!", Toast.LENGTH_SHORT).show()
                        Navigation.findNavController(view).navigate(R.id.action_fragmentRegister_to_mainFragment)

                    } else {
                        usernameInput.error = "This username is already taken"
                    }
                }
            }
        }
    }
}