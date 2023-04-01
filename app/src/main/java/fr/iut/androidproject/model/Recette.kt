package fr.iut.androidproject.model

class Recette(val id: String, val nom: String, val description: String, val image: String,
              val area : String, val category: String, val ingredients: List<String>,
              val measures: List<String>)
