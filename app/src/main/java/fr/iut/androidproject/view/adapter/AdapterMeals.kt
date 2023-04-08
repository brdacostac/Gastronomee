package fr.iut.androidproject.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
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

    fun updateAddList(newList: List<Recette>) {
        mealList = mealList.plus(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecettesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.celulle_recettes,parent,false)
        return RecettesViewHolder(view).apply {
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
                navController.navigate(R.id.action_fragmentAllMealsCategory_to_mealDetailFragment, bundle)
            }
        }
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

}