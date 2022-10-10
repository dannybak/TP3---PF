package com.example.scalonetaapp.fragments

import  androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.scalonetaapp.R
import com.example.scalonetaapp.entities.Player
import com.example.scalonetaapp.entities.PlayerRepository

class PlayerDetails : Fragment() {

    lateinit var v : View

    lateinit var backButton : Button
    lateinit var fullname : TextView
    lateinit var age : TextView
    lateinit var birthplace : TextView
    lateinit var position : TextView
    lateinit var number : TextView
    lateinit var imagePlayer : ImageView

    private var repository = PlayerRepository()
    lateinit var player : Player
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_player_details, container, false)

        backButton = v.findViewById(R.id.backButton)
        fullname = v.findViewById(R.id.fullname)
        age = v.findViewById(R.id.age)
        birthplace = v.findViewById(R.id.birthPlace)
        position = v.findViewById(R.id.position)
        number = v.findViewById(R.id.number)
        imagePlayer = v.findViewById(R.id.imagePlayer)

        val receiveIndex = PlayerDetailsArgs.fromBundle(requireArguments()).playerIndex
        player = repository.getPlayers()[receiveIndex]

        val nameText = "Nombre completo: " + player.fullname
        val ageText = "Edad: " + player.age.toString()
        val birthText = "Lugar de nacimiento: " + player.birthPlace
        val positionText = "Posicion: " + player.position
        val numberText = "Dorsal: " + player.number.toString()

        fullname.text = nameText
        age.text = ageText
        birthplace.text = birthText
        position.text = positionText
        number.text = numberText

        //Glide
        //.centerCrop()
        Glide
            .with(v)
            .load(player.img)
            .into(imagePlayer);

        backButton.setOnClickListener{
            v.findNavController().navigateUp()
        }

        return v
    }



}