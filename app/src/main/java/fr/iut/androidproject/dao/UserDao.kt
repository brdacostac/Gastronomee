package fr.iut.androidproject.dao

import androidx.room.*
import fr.iut.androidproject.entity.EntityUser

// Cette iterface contient les méthodes pour interagir avec la table user

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<EntityUser>

    @Insert
    suspend fun insertUser(entityUser: EntityUser)

    @Update
    suspend fun updateUser(entityUser: EntityUser)

    @Delete
    suspend fun deleteUser(entityUser: EntityUser)

    @Query("SELECT * FROM users WHERE username = :username")
    suspend fun getUserByUsername(username: String): EntityUser?

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    suspend fun getUserByUsernameAndPassword(username: String, password: String): EntityUser?
}