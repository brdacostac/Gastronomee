package fr.iut.androidproject.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import fr.iut.androidproject.R
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import fr.iut.androidproject.dao.UserDao
import fr.iut.androidproject.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FragmentIntro : Fragment() {

    private lateinit var userDao: UserDao
    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.fragment_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userDao = AppDatabase.getInstance(requireContext()).userDao() // à voir

        val usernameInput = view.findViewById<EditText>(R.id.username_input)
        val passwordInput = view.findViewById<EditText>(R.id.password_input)

        val loginBtn = view.findViewById<View>(R.id.startBtn)
        val registerBtn = view.findViewById<View>(R.id.registerBtn)


        loginBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_fragmentLogin)
        }

        loginBtn.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Check all your informations", Toast.LENGTH_SHORT).show()
            } else {
                viewModelScope.launch {
                    val user = userDao.getUserByUsernameAndPassword(username, password)
                    if (user != null) {
                        Toast.makeText(requireContext(), "Sucess!", Toast.LENGTH_SHORT).show()

                        val bundle = bundleOf(
                            "USER_ID" to user.fullname,
                            "USER_FULLNAME" to user.username,
                            "USER_PASSWORD" to user.password
                        )
                        Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_fragmentLogin, bundle)

                    } else {
                        Toast.makeText(requireContext(), "Username or password not correct", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }


}