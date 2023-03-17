package fr.iut.androidproject.view

import UserRepository
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import fr.iut.androidproject.R
import fr.iut.androidproject.entity.User

class PresentationRecetteActivity : AppCompatActivity() {
    private lateinit var recipeImage: ImageView
    private lateinit var recipeName: TextView
    private lateinit var recipeCategory: TextView
    private lateinit var recipeDifficulty: TextView
    private lateinit var recipeDuration: TextView
    private lateinit var recipeServing: TextView
    private lateinit var recipeIngredientsList: RecyclerView
    private lateinit var recipeUtensilsList: RecyclerView
    private lateinit var recipePreparationButton: Button
    private lateinit var recipeAuthorImage: ImageView
    private lateinit var recipeAuthorName: TextView
    private lateinit var recipeAuthorProfileButton: Button
    private lateinit var recipeAuthorRating: RatingBar
    private lateinit var recipeCommentsButton: Button

    private lateinit var userRepository: UserRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation_recette)
        recipeImage = findViewById(R.id.recipe_image)
        recipeName = findViewById(R.id.recipe_name)
        recipeCategory = findViewById(R.id.recipe_category)
        recipeDifficulty = findViewById(R.id.recipe_difficulty)
        recipeDuration = findViewById(R.id.recipe_duration)
        recipeServing = findViewById(R.id.recipe_serving)
        recipeIngredientsList = findViewById(R.id.recipe_ingredients_list)
        recipeUtensilsList = findViewById(R.id.recipe_utensils_list)
        recipePreparationButton = findViewById(R.id.recipe_preparation_button)
        recipeAuthorImage = findViewById(R.id.recipe_author_image)
        recipeAuthorName = findViewById(R.id.recipe_author_name)
        recipeAuthorProfileButton = findViewById(R.id.recipe_author_profile_button)
        recipeAuthorRating = findViewById(R.id.recipe_author_rating)
        recipeCommentsButton = findViewById(R.id.recipe_comments_button)

        recipeImage.setImageResource(R.drawable.recette)
        recipeName.text = "Nom de la recette"
        recipeCategory.text = "Catégorie du plat"
        recipeDifficulty.text = "Difficulté : Facile"
        recipeDuration.text = "Durée : 30 minutes"
        recipeServing.text = "Pour 4 personnes"


        val ingredients = listOf("Ingrédient 1", "Ingrédient 2", "Ingrédient 3")
        val utensils = listOf("Ustensile 1", "Ustensile 2", "Ustensile 3")

        val ingredientsAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredients)
        val utensilsAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, utensils)


        recipeAuthorImage.setImageResource(R.drawable.profile)
        recipeAuthorName.text = "Nom de l'auteur"
        recipeAuthorRating.rating = 4.5f

        recipePreparationButton.setOnClickListener {
            // à faire
        }
        recipeAuthorProfileButton.setOnClickListener {
            // à faire
        }
        recipeCommentsButton.setOnClickListener {
            // à faire
        }
        userRepository = UserRepository(this)

        val user = User(1,"John Doe", "johndoe", "password")
        userRepository.insertUser(user)

        val users = userRepository.getAllUsers()
    }

}