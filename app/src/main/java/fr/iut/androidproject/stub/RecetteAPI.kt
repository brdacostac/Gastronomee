package fr.iut.androidproject.stub

import fr.iut.androidproject.model.Recette
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL

public class RecetteAPI() {

    val listeTeste = mutableListOf<Recette>()
    val recette1 = Recette(1, "Nom de la recette 1", "Description de la recette 1")
    val recette2 = Recette(2, "Nom de la recette 2", "Description de la recette 2")
    val recette3 = Recette(3, "Nom de la recette 3", "Description de la recette 3")



    private fun getJSON(url: String): String {
        return URL(url).readText()
    }

    fun getRecettes(nomRecette: String): List<Recette> {
        val recettes = mutableListOf<Recette>()

        val json = getJSON("https://www.themealdb.com/api/json/v1/1/search.php?s=$nomRecette")

        val obj = JSONObject(json)
        val mealsArray = obj.getJSONArray("meals")

        for (i in 0 until mealsArray.length()) {
            val mealObj = mealsArray.getJSONObject(i)

            val ingredients = mutableListOf<String>()
            for (j in 1..20) {
                if (!mealObj.isNull("strIngredient$j") && mealObj.getString("strIngredient$j").isNotEmpty()) {
                    val ingredient = "${mealObj.getString("strIngredient$j")} (${mealObj.getString("strMeasure$j")})"
                    ingredients.add(ingredient)
                }
            }
            val recette = Recette(mealObj.getInt("idMeal"), mealObj.getString("strMeal"), ingredients.joinToString(", "))
            recettes.add(recette)
        }

        return recettes
    }

    fun load():List<Recette>{
        listeTeste.add(recette1)
        listeTeste.add(recette2)
        listeTeste.add(recette3)
        return listeTeste
    }
}
