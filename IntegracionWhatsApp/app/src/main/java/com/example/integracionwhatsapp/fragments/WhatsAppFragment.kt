package com.example.integracionwhatsapp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.integracionwhatsapp.R
import com.example.integracionwhatsapp.databinding.ActivityMainBinding.inflate
import com.example.integracionwhatsapp.databinding.FragmentWhatsAppBinding.inflate
import com.example.integracionwhatsapp.entities.Prestador
import com.example.integracionwhatsapp.entities.PrestadorRepository
import com.example.integracionwhatsapp.viewModels.WhatsAppViewModel

class WhatsAppFragment : Fragment() {

    lateinit var v : View
    private val viewModel: WhatsAppViewModel by viewModels()

    /*
    companion object {
        fun newInstance() = WhatsAppFragment()
    }
    */

    lateinit var name : TextView
    lateinit var lastname : TextView
    lateinit var age : TextView
    lateinit var tel : TextView
    lateinit var rubro : TextView
    lateinit var img : TextView
    lateinit var prestadorImg : ImageView
    lateinit var finalizarButton : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_whats_app, container, false)

        name = v.findViewById(R.id.nombre)
        lastname = v.findViewById(R.id.apellido)
        rubro = v.findViewById(R.id.rubro)
        prestadorImg = v.findViewById(R.id.prestadorImg)
        finalizarButton = v.findViewById(R.id.finalizarButton)

        viewModel.setView(v)

        return v

    }

    /*
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(WhatsAppViewModel::class.java)
        // TODO: Use the ViewModel
    }
    */

    override fun onStart() {
        super.onStart()
        val prestador = viewModel.getPrestadorById(1)

        name.text = prestador.name
        lastname.text = prestador.lastname
        rubro.text = prestador.rubro

        //Glide
        //.centerCrop()
        Glide
            .with(v)
            .load(prestador.img)
            .into(prestadorImg);

        finalizarButton.setOnClickListener{
            viewModel.finalizar(prestador.tel)
        }

    }

}