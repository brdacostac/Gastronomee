package fr.iut.androidproject.view.adapter

import fr.iut.androidproject.view.viewHolder.RecommendedViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
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
        return RecommendedViewHolder(view).apply {
            itemView.setOnClickListener {
                val recette = mealList[adapterPosition]
                val bundle = bundleOf(
                    "strMeal" to recette.nom,
                    "strInstructions" to recette.description,
                    "strMealThumb" to recette.image,
                    "strArea" to recette.area,
                    "strCategory" to recette.category,
                )
                bundle.putStringArrayList("listeIngredients", ArrayList(recette.ingredients))
                bundle.putStringArrayList("listeMesures", ArrayList(recette.measures))

                val navController = Navigation.findNavController(it)
                navController.navigate(R.id.action_fragmentLogin_to_mealDetailFragment, bundle)
            }
        }
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

}