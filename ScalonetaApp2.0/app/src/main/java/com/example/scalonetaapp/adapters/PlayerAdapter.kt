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
    class PlayerHolder (v: View) : RecyclerView.ViewHolder(v) {
        private var view: View

        init { this.view = v }

        fun setFullName (fullname : String){
            var txtFullName : TextView = view.findViewById(R.id.fullnameTextView)
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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_player,parent,false)
        return (PlayerHolder(view))
    }

    override fun onBindViewHolder(holder: PlayerHolder, position: Int) {
        holder.setFullName(playerList[position].fullname)
        holder.setPosition(playerList[position].position)
        holder.setImg(playerList[position].img)

        holder.getCardView().setOnClickListener {
            onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

}