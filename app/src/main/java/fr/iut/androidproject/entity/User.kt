package fr.iut.androidproject.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// Table user dans la BD

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val fullname: String,
    val username: String,
    val password: String
)
