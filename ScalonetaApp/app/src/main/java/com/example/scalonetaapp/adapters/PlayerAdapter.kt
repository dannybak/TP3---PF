package com.example.scalonetaapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.scalonetaapp.R
import com.example.scalonetaapp.entities.Player

class PlayerAdapter (var playerList : MutableList <Player>,
                     var onClick : (Int) -> Unit) : RecyclerView.Adapter<PlayerAdapter.PlayerHolder>()
{
    /**
    PlayerHolder es una inner class que hereda, a su vez, de RecyclerView.
    Funcion: se comunica con el .xml de del item. El parametro "View" es la instancia de ese .xml
    **/
    class PlayerHolder (v: View) : RecyclerView.ViewHolder(v) {
        private var view: View

        init { this.view = v }

        /**
        Creo metodos que quiero que se ejecuten cuando se rendericen cada uno de los items.
        Con esto nos conectamos con el item.
        **/
        //--> Estos metodos van a buscar el TextView del item y setearles el parametro que reciben.
        fun setFullName (fullname : String){
            var txtFullName : TextView = view.findViewById(R.id.fullnameTextView) //Este findViewById es del item (no del fragment)
            txtFullName.text = fullname
        }

        fun setPosition (position : String){
            var txtPosition : TextView = view.findViewById(R.id.positionTextView)
            txtPosition.text = position
        }

        fun setImg (img : String){
            var imgPlayer : ImageView = view.findViewById(R.id.imgPlayer)
            Glide
                .with(view)
                .load(img)
                .into(imgPlayer);
        }

        fun getCardView () : CardView {
            return view.findViewById(R.id.playerCard)
        }
    }

    //--> Copy-paste que se hace de la misma manera:
    // Esto viene a buscar el item_player.xml (vista).
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_player,parent,false)
        return (PlayerHolder(view))
    }

    //--> Esto itera la lista. Abstractamente es como un for (sin embargo, solamente itera los elementos que
    // vemos en pantalla. A medida que vamos scrolleando, vemos los otros items (mejor perfomance).
    override fun onBindViewHolder(holder: PlayerHolder, position: Int) {
        holder.setFullName(playerList[position].fullname)
        holder.setPosition(playerList[position].position)
        holder.setImg(playerList[position].img)

        holder.getCardView().setOnClickListener {
            onClick(position)
        }
    }

    //--> Devuelve el tamanio de la lista
    override fun getItemCount(): Int {
        return playerList.size
    }

}