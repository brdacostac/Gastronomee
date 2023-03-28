package fr.iut.androidproject.view.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import fr.iut.androidproject.R
import fr.iut.androidproject.model.Category
import fr.iut.androidproject.model.Recette


class CategoryViewHolder(itemView: View) : ViewHolder(itemView){
    private val nomTextView: TextView = itemView.findViewById(R.id.nomCategory)
    private val imageTextView: TextView = itemView.findViewById(R.id.imageCategory)

    fun bind(category: Category) {
        nomTextView.text = category.nom
        imageTextView.text = category.image
    }
}