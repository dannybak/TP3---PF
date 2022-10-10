package com.example.scalonetaapp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.example.scalonetaapp.R
import com.example.scalonetaapp.entities.PlayerRepository
import com.google.android.material.snackbar.Snackbar
import com.example.scalonetaapp.entities.User
import com.example.scalonetaapp.entities.UserRepository

class login : Fragment() {

    lateinit var v : View

    lateinit var inputUsername : EditText
    lateinit var inputPassword : EditText
    lateinit var buttonSend : Button

    private var userRepository = UserRepository()
    private var name : String = ""
    private var password : String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_login, container, false)

        inputUsername = v.findViewById(R.id.usernamePlainText)
        inputPassword = v.findViewById(R.id.passwordPlainText)
        buttonSend = v.findViewById(R.id.loginButton)

        return v;
    }

    override fun onStart() {
        super.onStart()

        buttonSend.setOnClickListener{

            if(inputUsername.text.isNotEmpty() && inputPassword.text.isNotEmpty()){
                name = inputUsername.text.toString();
                password = inputPassword.text.toString()

                val found : User? = userRepository.getUsers().find{x -> x.username == name}

                if(found != null && found.password == password){

                    val action1To2 = loginDirections.actionLogin2ToMainActivity()
                    v.findNavController().navigate(action1To2)

                }
                else{
                    Snackbar.make(it, "Nombre de usuario y/o constraseña incorrectas", Snackbar.LENGTH_SHORT).show()
                }
            }
            else{
                Snackbar.make(it, "Complete nombre de usuario y/o constraseña", Snackbar.LENGTH_SHORT).show()
            }
        }

    }

}