package fr.iut.androidproject.view.adapter

import RecommendedViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import fr.iut.androidproject.R
import fr.iut.androidproject.model.Recette

class AdapterRecommended(var mealList : List<Recette> ) : Adapter<RecommendedViewHolder>() {
    override fun onBindViewHolder(holder: RecommendedViewHolder, position: Int) {
        val recette = mealList[position]
        holder.bind(recette)
    }

    fun updateList(newList: List<Recette>) {
        mealList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.celulle_recommended,parent,false)
        return RecommendedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

}