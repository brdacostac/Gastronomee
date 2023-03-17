package fr.iut.androidproject

import androidx.room.*
import fr.iut.androidproject.entity.User

// Cette iterface contient les méthodes pour interagir avec la table user

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Insert
    fun insertUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    fun getUserByUsernameAndPassword(username: String, password: String): User?
}

