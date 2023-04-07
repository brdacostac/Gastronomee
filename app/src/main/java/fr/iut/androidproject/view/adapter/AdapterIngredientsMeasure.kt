package fr.iut.androidproject.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.iut.androidproject.R
import fr.iut.androidproject.view.viewHolder.RecettesViewHolder

class AdapterIngredientsMeasure(var stringList : ArrayList<String> ) : RecyclerView.Adapter<RecettesViewHolder>() {

    override fun onBindViewHolder(holder: RecettesViewHolder, position: Int) {
        val ingredientsMeasure = stringList[position]
        holder.bind(ingredientsMeasure)
    }

    fun updateList(newList: ArrayList<String>) {
        stringList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecettesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.celulle_ingredientsmeasures,parent,false)
        return RecettesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return stringList.size
    }

}