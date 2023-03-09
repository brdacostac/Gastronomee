package fr.iut.androidproject.stub

import fr.iut.androidproject.model.Recette
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL

class RecetteAPI() {

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
}
