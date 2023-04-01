package fr.iut.androidproject.view.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import fr.iut.androidproject.R
import fr.iut.androidproject.model.Recette


class RecettesViewHolder(itemView: View) : ViewHolder(itemView){
    private val titleTextView: TextView = itemView.findViewById(R.id.titleMeal)
    private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionMeal)

    fun bind(recette: Recette) {
        titleTextView.text = recette.nom
        descriptionTextView.text = recette.description
    }
    fun bind(string: String) {
        descriptionTextView.text = string
    }
}