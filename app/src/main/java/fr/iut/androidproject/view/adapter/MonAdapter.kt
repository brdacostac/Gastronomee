package fr.iut.androidproject.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import fr.iut.androidproject.R
import fr.iut.androidproject.model.Recette
import fr.iut.androidproject.view.viewHolder.MonViewHolder

class MonAdapter(var mealList : List<Recette> ) : Adapter<MonViewHolder>() {
    override fun onBindViewHolder(holder: MonViewHolder, position: Int) {
        val recette = mealList[position]
        holder.bind(recette)
    }

    fun updateList(newList: List<Recette>) {
        mealList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.celulle_recettes,parent,false)
        return MonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

}