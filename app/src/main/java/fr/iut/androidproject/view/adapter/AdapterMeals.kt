package fr.iut.androidproject.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import fr.iut.androidproject.R
import fr.iut.androidproject.model.Recette
import fr.iut.androidproject.view.viewHolder.RecettesViewHolder

class AdapterMeals(var mealList : List<Recette> ) : Adapter<RecettesViewHolder>() {
    override fun onBindViewHolder(holder: RecettesViewHolder, position: Int) {
        val recette = mealList[position]
        holder.bind(recette)
    }

    fun updateList(newList: List<Recette>) {
        mealList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecettesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.celulle_recettes,parent,false)
        return RecettesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

}