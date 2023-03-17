package fr.iut.androidproject.network


import com.squareup.moshi.Json

data class Recette(
    val idMeal: String,
    val strMeal: String,
    val strInstructions: String,
    @Json(name = "img_src") val strMealThumb: String
)