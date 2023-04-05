package fr.iut.androidproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.iut.androidproject.R


class FragmentAllMealsCategory : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    //ICI ON VA RECUPERER LE BUNDLE PASSE PAR ADAPTERCATEGORY, CE QU'IL FAUT FAIRE CE PRENDS
    //LE NOM DE LA CATEGORY PASSE ET FAIRE UNE REQUETE A L'API POUR DONNER TOUT LES MEALS DE CETTE CATEGORY
    //ENSUITE VA FALOIR FAIRE LA MEME CHOSE QUE POUR RECOMMENDED AVEC LE ITEMCLIC ET TOUT

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all_meals_category, container, false)
    }
}