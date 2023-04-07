package fr.iut.androidproject.view.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import fr.iut.androidproject.R
import fr.iut.androidproject.model.Recette


class RecettesViewHolder(itemView: View) : ViewHolder(itemView){
    private val titleTextView: TextView = itemView.findViewById(R.id.titleMeal)
    private val imageImageView: ImageView = itemView.findViewById(R.id.imageMeal)

    private val measuresIngredients: TextView = itemView.findViewById(R.id.measuresIngredientsText)
    fun bind(recette: Recette) {
        titleTextView.text = recette.nom
        Picasso.get().load(recette.image).into(imageImageView)
    }
    fun bind(string: String) {
        measuresIngredients.text = string
    }
}