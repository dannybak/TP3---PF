package com.example.scalonetaapp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scalonetaapp.R
import com.example.scalonetaapp.adapters.PlayerAdapter
import com.example.scalonetaapp.entities.Player
import com.example.scalonetaapp.entities.PlayerRepository

class scalonetaList : Fragment() {

    lateinit var v : View

    /** --> Otro ejemplo de aplicacion del ADAPTER
    private var playerList : MutableList<Player> = mutableListOf();
    lateinit var playerAdapter : PlayerAdapter
    */

    lateinit var recyclerPlayer : RecyclerView

    private var repository = PlayerRepository() //--> Repositorio que contiene la lista de jugadores

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        v = inflater.inflate(R.layout.fragment_scaloneta_list, container, false)

        recyclerPlayer = v.findViewById(R.id.RecyclerPlayer)

        return v
    }

    override fun onStart() {
        super.onStart()

        //--> Tamanio
        recyclerPlayer.setHasFixedSize(true)

        //--> LinearLayoutManager: como quiero que sea el layout de la lista (una al lado de otra o una abajo de otra)
        recyclerPlayer.layoutManager  = LinearLayoutManager(requireContext())

        //--> Esto en caso de que la lista este en el fragment. Pero como lo tenemos en una clase 'Entities'...:
        /**
        playerAdapter = PlayerAdapter(___Lista de jugadores___){ pos ->
            __codigo__
        }
        recyclerPlayer.adapter = playerAdapter
        **/

        recyclerPlayer.adapter = PlayerAdapter(repository.getPlayers()){ index ->
            onItemClick(index)  //--> Para no tener el codigo en esta funcion, creamos otra funcion aparte.
        }

    }

    //--> Aca va el codigo de la navigation en donde se muestra el detalle del item cliqueado en otro fragment.
    fun onItemClick (pos : Int){
        val action1To2 = scalonetaListDirections.actionScalonetaListToPlayerDetails(pos)
        v.findNavController().navigate(action1To2)
    }

}