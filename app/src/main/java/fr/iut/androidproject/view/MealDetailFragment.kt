package fr.iut.androidproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import fr.iut.androidproject.R


class MealDetailFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_mealdetail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val strMeal = arguments?.getString("strMeal")
        val strInstructions = arguments?.getString("strInstructions")
        val strMealThumb = arguments?.getString("strMealThumb")
        val strArea = arguments?.getString("strArea")
        val strCategory = arguments?.getString("strCategory")

        val textViewTitle: TextView = view.findViewById(R.id.titleMeal)
        textViewTitle.text = "$strMeal"

        val imageMealImageView: ImageView = view.findViewById(R.id.imageMeal)
        Picasso.get().load("$strMealThumb").into(imageMealImageView)

        val areaTextView: TextView = view.findViewById(R.id.areaMeal)
        areaTextView.text = "$strArea"

        val categoryTextView: TextView = view.findViewById(R.id.categoryMeal)
        categoryTextView.text = "$strCategory"

        val instructionsTextView: TextView = view.findViewById(R.id.textViewInstructions)
        instructionsTextView.text = "$strInstructions"

    }



}