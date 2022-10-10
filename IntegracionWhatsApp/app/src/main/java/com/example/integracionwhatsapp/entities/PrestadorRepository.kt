package com.example.integracionwhatsapp.entities

class PrestadorRepository {

    private var prestadorList : MutableList<Prestador> = mutableListOf()

    //--> El numero de telefono debe ser: 54 9 ___(los 11 digitos del cel)___
    //--> El + al inicio no va (es decir, +54911223344 NO!!)

    init{
        prestadorList.add(Prestador(1,
            "Ricardo",
            "Iorio",
            60,
            "5491139004865",
            "Plomero",
            "https://indiehoy.com/wp-content/uploads/2018/09/ricardo-iorio-1200x900.jpg"
        ))

        prestadorList.add(Prestador(2,
            "Leandro",
            "Messirve",
            18,
            "5491139004865",
            "Electricista",
            "https://pbs.twimg.com/profile_images/1208881683115773953/UIiHw_7d_400x400.jpg"
        ))
    }

    fun getPrestadores () : MutableList<Prestador>{
        return prestadorList
    }
}