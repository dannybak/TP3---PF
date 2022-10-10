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
import com.example.scalonetaapp.database.appDatabase
import com.example.scalonetaapp.database.playerDao
import com.example.scalonetaapp.entities.Player
import com.example.scalonetaapp.entities.PlayerRepository
import com.google.android.material.snackbar.Snackbar

class addPlayer : Fragment() {

    private var minAge : Int = 15
    private var maxAge : Int = 60
    private var minNumber : Int = 0
    private var maxNumber : Int = 99

    lateinit var v : View

    //--> Base de datos
    private var db: appDatabase? = null
    private var playerDao: playerDao? = null

    //--> layout
    lateinit var addFullname : EditText
    lateinit var addPosition : EditText
    lateinit var addBirthPlace : EditText
    lateinit var addNumber : EditText
    lateinit var addAge : EditText
    lateinit var addImg : EditText

    lateinit var buttonSend : Button

    //--> Repositorio de jugadores
    private var playerRepository = PlayerRepository()

    //--> Esta variable nos sirve para almacenar los jugadores de la BD
    //private var playerList : MutableList<Player?>? = mutableListOf()

    //--> ID que se va sumando cada vez que agregamos un nuevo objeto
    var i : Int = playerRepository.getPlayers().size

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_add_player, container, false)

        addFullname = v.findViewById(R.id.addFullname)
        addPosition = v.findViewById(R.id.addPosition)
        addBirthPlace = v.findViewById(R.id.addBirthplace)
        addNumber = v.findViewById(R.id.addNumber)
        addAge = v.findViewById(R.id.addAge)
        addImg = v.findViewById(R.id.addImg)
        buttonSend = v.findViewById(R.id.addPlayerButton)

        //playerList = playerDao?.loadAllPlayers()
        //i += playerList?.size!!

        return v
    }

    override fun onStart() {
        super.onStart()

        db = appDatabase.getAppDataBase(v.context)
        playerDao = db?.playerDao()

        buttonSend.setOnClickListener{

            val condition : Boolean = addFullname.text.isNotEmpty() &&
                    addPosition.text.isNotEmpty() &&
                    addBirthPlace.text.isNotEmpty() &&
                    addNumber.text.isNotEmpty() &&
                    addAge.text.isNotEmpty() &&
                    addImg.text.isNotEmpty()

            if(condition){

                val fullname = addFullname.text.toString()
                val position = addPosition.text.toString()
                val birthplace = addBirthPlace.text.toString()
                val number = addNumber.text.toString().toInt()
                val age = addAge.text.toString().toInt()
                val img = addImg.text.toString()

                if (number < minNumber || number > 99){
                    Snackbar.make(it, "El dorsal debe ser mayor a " + minNumber + " y mayor a " + maxNumber, Snackbar.LENGTH_SHORT).show()
                }
                else if (age < minAge || age > maxAge){
                    Snackbar.make(it, "La edad no debe ser menor a " + minAge + " ni mayor a " + maxAge, Snackbar.LENGTH_SHORT).show()
                }
                else{
                    val found : Player? = playerRepository.getPlayers().find{ x -> x.fullname == fullname }

                    if(found != null){
                        Snackbar.make(it, "El jugador ya existe", Snackbar.LENGTH_SHORT).show()
                    }
                    else{
                        //--> Se hace el insert a la BD, una vez validado todos los datos
                        playerDao?.insertPlayer(Player(i, fullname, position, birthplace, age, number, img))
                        i += 1
                    }
                }
            }
            else{
                Snackbar.make(it, "Complete todos los campos", Snackbar.LENGTH_SHORT).show()
            }
        }

    }


}