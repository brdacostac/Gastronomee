package fr.iut.androidproject.view.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import fr.iut.androidproject.R
import fr.iut.androidproject.model.Recette

class RecettesViewHolder(itemView: View) : ViewHolder(itemView){
    fun bind(recette: Recette) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleMeal)
        val imageImageView: ImageView = itemView.findViewById(R.id.imageMeal)
        titleTextView.text = recette.nom
        Picasso.get().load(recette.image).into(imageImageView)
    }
    fun bind(string: String) {
        val measuresIngredients: TextView = itemView.findViewById(R.id.measuresIngredientsText)
        measuresIngredients.text = string
    }
}
