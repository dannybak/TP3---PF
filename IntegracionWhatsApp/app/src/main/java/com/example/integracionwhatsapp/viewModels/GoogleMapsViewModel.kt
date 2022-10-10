package com.example.integracionwhatsapp.viewModels

import android.app.Activity
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.integracionwhatsapp.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.snackbar.Snackbar


class GoogleMapsViewModel : ViewModel() , OnMapReadyCallback{

    private lateinit var view : View
    val direction = MutableLiveData<String>()

    //--> Google Maps in Fragment
    private lateinit var supportMapFragment : SupportMapFragment

    private var addressList : MutableList<Address> = mutableListOf()

    private var doubleLat : Double = 0.0
    private var doubleLong : Double = 0.0

    //----------------------------- SETTERS ---------------------------------------------------
    fun setView(v : View){
        this.view = v
    }

    //---------------------------------- FUNCION PRINCIPAL ----------------------------------------------
    //--> Crea el google maps en el fragment pasado por params
    fun createGoogleMaps(f : Fragment, dir : String){
        changeDirection(dir)
        if(!f.isAdded) return;
        supportMapFragment = f.childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        supportMapFragment.getMapAsync(this)
    }

    //--> Callback del getMapAsync
    override fun onMapReady(googleMap: GoogleMap) {
        val mMap = googleMap

        val dir = convertStringToLatLng(this.direction.value!!)
        val zoomLevel = 16.0f

        //--> Metodo que agrega un marcador (se usa el .clear() para borrar viejos marcadores)
        mMap.clear()
        mMap.addMarker(
            MarkerOptions()
                .position(dir)
                .title(this.direction.value!!))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dir, zoomLevel))
    }

    //--------------------------------- FUNCIONES PRIVADAS -----------------------------------------------
    //--> Convierte el string (la direccion que se pasa por el textview) a coordenadas
    //--> Chequea que el string pasado sea valido (en caso de no serlo, se muestra un msj)
    private fun convertStringToLatLng(direction : String) : LatLng{

        val geocoder : Geocoder = Geocoder(view.context)
        addressList = geocoder.getFromLocationName(direction, 1)

        if(addressList == null || addressList.size == 0){
            Snackbar.make(view, "Debes agregar una direccion existente", Snackbar.LENGTH_SHORT).show()
        }
        else{
            doubleLat = addressList[0].latitude
            doubleLong = addressList[0].longitude
        }

        return LatLng(doubleLat, doubleLong)
    }

    //--> Establece el cambio de la direccion (string) en la variable 'MutableLiveData'
    private fun changeDirection(dir : String){
        if(dir.isNullOrEmpty() || dir == ""){
            this.direction.value = "Capital Federal, Buenos Aires, Argentina"
        }
        else{
            this.direction.value = dir
        }
        view.hideKeyboard()
    }

    //----------------------------------- OTROS ---------------------------------------------
    //--> Esconde el keyboard (este metodo se creó principalmente para que se muestre el snackbar)
    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

}