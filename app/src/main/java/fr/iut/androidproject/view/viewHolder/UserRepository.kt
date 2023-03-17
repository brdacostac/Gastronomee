import android.content.Context
import fr.iut.androidproject.database.AppDatabase
import fr.iut.androidproject.entity.User

// Inclut les fonctions pour accéder, modifier, ajouter ou supprimer des utilisateurs de la BD

class UserRepository(context: Context) {
    private val userDao = AppDatabase.getInstance(context).userDao()

    fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    fun getUserByUsernameAndPassword(username: String, password: String): User? {
        return userDao.getUserByUsernameAndPassword(username, password)
    }
}