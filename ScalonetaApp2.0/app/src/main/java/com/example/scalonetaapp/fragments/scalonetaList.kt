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
import com.example.scalonetaapp.entities.User
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class scalonetaList : Fragment() {

    lateinit var v : View

    lateinit var recyclerPlayer : RecyclerView
    lateinit var addFloatingButton : FloatingActionButton

    private var repository = PlayerRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        v = inflater.inflate(R.layout.fragment_scaloneta_list, container, false)

        addFloatingButton = v.findViewById(R.id.addFloatingButton)

        recyclerPlayer = v.findViewById(R.id.RecyclerPlayer)

        return v
    }

    override fun onStart() {
        super.onStart()

        //--> Add floating button
        addFloatingButton.setOnClickListener{
            val action1To2 = scalonetaListDirections.actionScalonetaListToAddPlayer2()
            v.findNavController().navigate(action1To2)
        }

        //--> Recycler view
        recyclerPlayer.setHasFixedSize(true)

        recyclerPlayer.layoutManager  = LinearLayoutManager(requireContext())

        recyclerPlayer.adapter = PlayerAdapter(repository.getPlayers()){ index ->
            onItemClick(index)
        }

    }

    fun onItemClick (pos : Int){
        val action1To2 = scalonetaListDirections.actionScalonetaListToPlayerDetails(pos)
        v.findNavController().navigate(action1To2)
    }

}