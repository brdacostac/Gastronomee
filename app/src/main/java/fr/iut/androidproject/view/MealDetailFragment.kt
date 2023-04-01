package fr.iut.androidproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.iut.androidproject.R
import fr.iut.androidproject.view.adapter.AdapterIngredientsMeasure
import fr.iut.androidproject.view.adapter.AdapterMeals
import fr.iut.androidproject.view.adapter.AdapterRecommended


class MealDetailFragment : Fragment() {

    private lateinit var adapterIngredients: AdapterIngredientsMeasure
    private lateinit var adapterMeasures: AdapterIngredientsMeasure

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listIngredients = arguments?.getStringArrayList("listeIngredients")
        val kotlinListIngredients = ArrayList(listIngredients ?: listOf())

        val listMeasures = arguments?.getStringArrayList("listeMesures")
        val kotlinListMeasures = ArrayList(listMeasures ?: listOf())

        adapterIngredients = AdapterIngredientsMeasure(kotlinListIngredients)
        adapterMeasures = AdapterIngredientsMeasure(kotlinListMeasures)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_mealdetail, container, false)

        val recyclerViewIngrediets = rootView.findViewById<RecyclerView>(R.id.recyclerViewIngredients)
        recyclerViewIngrediets.adapter = adapterIngredients
        recyclerViewIngrediets.layoutManager = LinearLayoutManager(context)

        val recyclerViewMeasures= rootView.findViewById<RecyclerView>(R.id.recyclerViewMeasures)
        recyclerViewMeasures.adapter = adapterMeasures
        recyclerViewMeasures.layoutManager = LinearLayoutManager(context)

        return rootView
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