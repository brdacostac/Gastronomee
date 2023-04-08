import android.content.Context
import fr.iut.androidproject.database.AppDatabase
import fr.iut.androidproject.entity.EntityUser

// Inclut les fonctions pour accéder, modifier, ajouter ou supprimer des utilisateurs de la BD

class UserRepository(context: Context) {
    private val userDao = AppDatabase.getInstance(context).userDao()

    suspend fun getAllUsers(): List<EntityUser> {
        return userDao.getAllUsers()
    }

    suspend fun insertUser(entityUser: EntityUser) {
        userDao.insertUser(entityUser)
    }

    suspend fun updateUser(entityUser: EntityUser) {
        userDao.updateUser(entityUser)
    }

    suspend fun deleteUser(entityUser: EntityUser) {
        userDao.deleteUser(entityUser)
    }

    suspend fun getUserByUsernameAndPassword(username: String, password: String): EntityUser? {
        return userDao.getUserByUsernameAndPassword(username, password)
    }
}