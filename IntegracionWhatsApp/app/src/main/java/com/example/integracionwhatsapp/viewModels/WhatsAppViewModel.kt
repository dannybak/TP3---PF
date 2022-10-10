package com.example.integracionwhatsapp.viewModels

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.integracionwhatsapp.entities.Prestador
import com.example.integracionwhatsapp.entities.PrestadorRepository
import android.view.View
import com.google.android.material.snackbar.Snackbar


class WhatsAppViewModel : ViewModel() {

    private var repository = PrestadorRepository()
    private lateinit var view : View
    //private var list : MutableList<Prestador> = mutableListOf()
    //val name = MutableLiveData<String>()

    //----------------------------- SETTERS ---------------------------------------------------
    fun setView(v : View){
        this.view = v
    }

    //---------------------------------------------------------------------------------------
    fun getPrestadorById(i : Int) : Prestador{
        return repository.getPrestadores()[i]
    }

    fun finalizar(tel : String){

        val msg = "Hola. Te quiero contratar"
        val packageWhatsApp = "com.whatsapp"

        if(isAppInstalled(packageWhatsApp)){

            val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, msg)
            putExtra("jid", "${tel}@s.whatsapp.net")
            type = "text/plain"
            setPackage(packageWhatsApp)
            }
            view.context.startActivity(sendIntent)

        }
        else{
            Snackbar.make(view, "Debes instalar Whatsapp", Snackbar.LENGTH_SHORT).show()
        }

    }

    //--> Chequea que la App este instalada
    private fun isAppInstalled(packageName: String): Boolean {
        val pm: PackageManager = view.context.packageManager
        return try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

    //--> Link para instalar whatsapp en google play (por web):
    //    https://play.google.com/store/apps/details?id=com.whatsapp
}