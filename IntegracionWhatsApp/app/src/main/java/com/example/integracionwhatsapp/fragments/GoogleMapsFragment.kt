package com.example.integracionwhatsapp.fragments

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
import com.example.integracionwhatsapp.R
import com.example.integracionwhatsapp.viewModels.GoogleMapsViewModel

class GoogleMapsFragment : Fragment() {

    lateinit var v : View
    private val viewModel: GoogleMapsViewModel by viewModels()

    lateinit var directionAEditText : EditText
    lateinit var directionBEditText : EditText
    lateinit var searchButton : Button
    lateinit var googleMapsAppButton : Button
    lateinit var kmindicator : TextView
    lateinit var remindTextView : TextView

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

        directionAEditText = v.findViewById(R.id.directionAEditText)
        directionBEditText = v.findViewById(R.id.directionBEditText)
        searchButton = v.findViewById(R.id.searchButton)
        kmindicator = v.findViewById(R.id.kmindicator)
        remindTextView = v.findViewById(R.id.remindTextView)
        googleMapsAppButton = v.findViewById(R.id.googleMapsAppButton)

        viewModel.setView(v)
        viewModel.createGoogleMaps(this, "Yatay 240", "Rio de Janeiro 471")

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
        remindTextView.text = "Recordar que la distancia es aproximada. Para ver los mejores caminos o medios de transporte, haz click en el siguiente boton:"

        viewModel.kmindicator.observe(viewLifecycleOwner, Observer { result ->
            kmindicator.text = result.toString()
        })
        viewModel.dirA.observe(viewLifecycleOwner, Observer { result ->
        })
        viewModel.dirB.observe(viewLifecycleOwner, Observer { result ->
        })

        searchButton.setOnClickListener{
            viewModel.createGoogleMaps(this, directionAEditText.text.toString(), directionBEditText.text.toString())
        }

        googleMapsAppButton.setOnClickListener{
            viewModel.redirectToGoogleMaps(directionAEditText.text.toString(), directionBEditText.text.toString())
        }
    }

}