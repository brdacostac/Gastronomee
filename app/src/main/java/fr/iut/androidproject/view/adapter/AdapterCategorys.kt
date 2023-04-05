package fr.iut.androidproject.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView.Adapter
import fr.iut.androidproject.R
import fr.iut.androidproject.model.Category
import fr.iut.androidproject.view.viewHolder.CategoryViewHolder

class AdapterCategorys(var categoryList : List<Category> ) : Adapter<CategoryViewHolder>() {

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList[position]
        holder.bind(category)
    }

    fun updateList(newList: List<Category>) {
        categoryList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.celulle_categorys, parent, false)
        return CategoryViewHolder(view).apply {
            itemView.setOnClickListener {
                val category = categoryList[adapterPosition]
                val bundle = bundleOf(
                    "strCategoryId" to category.id,
                    "strCategory" to category.nom,
                    "strCategoryThumb" to category.image
                )

                val navController = Navigation.findNavController(it)
                navController.navigate(R.id.action_fragmentLogin_to_fragmentAllMealsCategory, bundle)
            }
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

}