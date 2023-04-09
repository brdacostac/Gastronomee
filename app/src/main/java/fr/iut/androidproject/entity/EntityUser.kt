package fr.iut.androidproject.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// Représente la table user dans la BD

@Entity(tableName = "users")
data class EntityUser(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val fullname: String,
    val username: String,
    val password: String
)