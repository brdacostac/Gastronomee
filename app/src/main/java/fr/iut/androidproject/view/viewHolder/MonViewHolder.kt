package fr.iut.androidproject.view.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import fr.iut.androidproject.R
import fr.iut.androidproject.model.Category
import fr.iut.androidproject.model.Recette


class MonViewHolder(itemView: View) : ViewHolder(itemView){
    private val titleTextView: TextView = itemView.findViewById(R.id.nom)
    private val descriptionTextView: TextView = itemView.findViewById(R.id.description)

    fun bind(recette: Recette) {
        titleTextView.text = recette.nom
        descriptionTextView.text = recette.description
    }
}