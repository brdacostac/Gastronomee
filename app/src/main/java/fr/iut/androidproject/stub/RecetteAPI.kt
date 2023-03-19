package fr.iut.androidproject.stub

import fr.iut.androidproject.model.Recette
import java.net.URL


class RecetteAPI() {

    val listeTeste = mutableListOf<Recette>()
    val recette1 = Recette("1", "Nom de la recette 1", "Description de la recette 1")
    val recette2 = Recette("2", "Nom de la recette 2", "Description de la recette 2")
    val recette3 = Recette("3", "Nom de la recette 3", "Description de la recette 3")


    fun load():List<Recette>{
        listeTeste.add(recette1)
        listeTeste.add(recette2)
        listeTeste.add(recette3)
        return listeTeste
    }

}

