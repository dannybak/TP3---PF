package com.example.scalonetaapp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.scalonetaapp.R

class account : Fragment() {

    lateinit var v : View

    //lateinit var usernameTextView : TextView
    //lateinit var logoutButton : Button

    //lateinit var receiveUsername : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        v = inflater.inflate(R.layout.fragment_account, container, false)

        //usernameTextView = v.findViewById(R.id.usernameTextView)
        //logoutButton = v.findViewById(R.id.logoutButton)

        /**
        val text = "$receiveUsername"
        usernameTextView.text = text

        logoutButton.setOnClickListener{
            v.findNavController().navigateUp()
        }
         */

        return v
    }



}