package com.example.integracionwhatsapp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.integracionwhatsapp.R
import com.example.integracionwhatsapp.viewModels.GoogleMapsViewModel

class GoogleMapsFragment : Fragment() {

    lateinit var v : View
    private val viewModel: GoogleMapsViewModel by viewModels()

    lateinit var directionEditText : EditText
    lateinit var searchButton : Button
    lateinit var currentDirection : TextView

    /*
    companion object {
        fun newInstance() = GoogleMapsFragment()
    }
    */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_google_maps, container, false)

        directionEditText = v.findViewById(R.id.directionEditText)
        searchButton = v.findViewById(R.id.searchButton)
        currentDirection = v.findViewById(R.id.currentDirection)

        viewModel.setView(v)
        viewModel.createGoogleMaps(this, "")

        return v
    }

    /*
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GoogleMapsViewModel::class.java)
    }
    */

    override fun onStart() {
        super.onStart()

        viewModel.direction.observe(viewLifecycleOwner, Observer { result ->
            currentDirection.text = result.toString()
        })

        searchButton.setOnClickListener{
            viewModel.createGoogleMaps(this, directionEditText.text.toString())
        }
    }

}