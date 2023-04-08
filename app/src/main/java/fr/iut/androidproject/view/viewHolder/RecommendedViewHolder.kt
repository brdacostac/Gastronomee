package fr.iut.androidproject.view.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.iut.androidproject.R
import fr.iut.androidproject.model.Recette

class RecommendedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val nomTextView: TextView = itemView.findViewById(R.id.nomRecommended)
    private val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
    private val areaTextView: TextView = itemView.findViewById(R.id.areaTextView)
    private val imageTextView: ImageView = itemView.findViewById(R.id.imageRecommended)

    fun bind(recommendedRecette: Recette) {
        nomTextView.text = recommendedRecette.nom
        categoryTextView.text = recommendedRecette.category
        areaTextView.text = recommendedRecette.area
        Picasso.get().load(recommendedRecette.image).into(imageTextView)
    }
}