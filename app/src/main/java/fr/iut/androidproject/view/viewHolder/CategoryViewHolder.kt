package fr.iut.androidproject.view.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import fr.iut.androidproject.R
import fr.iut.androidproject.model.Category


class CategoryViewHolder(itemView: View) : ViewHolder(itemView){
    private val nomTextView: TextView = itemView.findViewById(R.id.nomCategory)
    private val imageTextView: ImageView = itemView.findViewById(R.id.imageCategory)

    fun bind(category: Category) {
        nomTextView.text = category.nom
        Picasso.get().load(category.image).into(imageTextView)
    }
}