package com.example.integracionwhatsapp.viewModels

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import android.net.Uri
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.integracionwhatsapp.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.android.material.snackbar.Snackbar
import com.google.maps.android.SphericalUtil


class GoogleMapsViewModel : ViewModel() , OnMapReadyCallback{

    private lateinit var view : View

    val dirA = MutableLiveData<String>()
    val dirB = MutableLiveData<String>()
    val kmindicator = MutableLiveData<String>()

    var addressList : MutableList<Address> = mutableListOf()

    //--> Google Maps in Fragment
    private lateinit var supportMapFragment : SupportMapFragment

    //----------------------------- SETTERS ---------------------------------------------------
    fun setView(v : View){
        this.view = v
    }

    //---------------------------------- FUNCION PRINCIPAL ----------------------------------------------
    //--> Crea el google maps en el fragment pasado por params
    fun createGoogleMaps(f : Fragment, dirA : String, dirB : String){
        changeDirections(dirA, dirB)

        if(!f.isAdded) return;
        supportMapFragment = f.childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        supportMapFragment.getMapAsync(this)

        view.hideKeyboard()
    }

    //--> Callback del getMapAsync
    override fun onMapReady(googleMap: GoogleMap) {

        val mMap = googleMap
        val dirA = convertStringToLatLng(this.dirA.value!! + ", CABA")
        val dirB = convertStringToLatLng(this.dirB.value!! + ", CABA")

        //--> .clear() borra viejos marcadores
        mMap.clear()
        //--> .addMarker agrega un marcador
        val markerA = mMap.addMarker(MarkerOptions().position(dirA).title(this.dirA.value!!))
        val markerB = mMap.addMarker(MarkerOptions().position(dirB).title(this.dirB.value!!))

        val listOfMarker = ArrayList<Marker>()
        listOfMarker.add(markerA!!)
        listOfMarker.add(markerB!!)

        //--> Muestra ruta en color
        mMap.addPolyline(
            PolylineOptions()
                .add(dirA, dirB)
                .width(5f)
                .color(Color.RED)
        )

        calculateKm(dirA, dirB) //--> Se pasan LatLng
        showAllMarkers(mMap, listOfMarker)
    }

    //--> Se redirecciona al prestador a Google Maps rara ver las rutas, mejores caminos, a pie, etc
    fun redirectToGoogleMaps(dirA : String, dirB : String){
        if(checkDirections(dirA!!, dirB!!)){
            val gmmIntentUri = Uri.parse("https://www.google.co.in/maps/dir/$dirA/$dirB")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            view.context.startActivity(mapIntent)
        }
    }

    //--------------------------------- FUNCIONES PRIVADAS -----------------------------------------------
    //--> Muestra los dos marcadores
    private fun showAllMarkers(mMap : GoogleMap, listOfMarker : ArrayList<Marker>){
        val b = LatLngBounds.Builder()
        for (m in listOfMarker) {
            b.include(m.position)
        }

        val cu = CameraUpdateFactory.newLatLngBounds(b.build(),100)  // 1° param: bounds, 2° param: paddingFromEdgeAsPX
        mMap.animateCamera(cu)
    }

    /*--> Convierte el string (la direccion que se pasa por el textview) a coordenadas
    Chequea que el string pasado sea valido (en caso de no serlo, se muestra un msj) */
    private fun convertStringToLatLng(dir : String) : LatLng{

        var lat = 0.0
        var lng = 0.0

        val geocoder : Geocoder = Geocoder(view.context)
        addressList = geocoder.getFromLocationName(dir, 1)

        if(addressList == null || addressList.size == 0){
            Snackbar.make(view, "Debes agregar una direccion existente", Snackbar.LENGTH_SHORT).show()
        }
        else{
            lat = addressList[0].latitude
            lng = addressList[0].longitude
        }

        return LatLng(lat, lng)
    }

    //--> Establece el cambio de la direccion (string) en la variable 'MutableLiveData'
    private fun changeDirections(dirA : String, dirB : String){
        if(checkDirections(dirA, dirB)){
            this.dirA.value = dirA
            this.dirB.value = dirB
        }
    }

    //--> Calcula la cantidad de km entre los dos puntos
    private fun calculateKm(dirA : LatLng, dirB : LatLng){
        var result = SphericalUtil.computeDistanceBetween(dirA, dirB);
        this.kmindicator.value = "${this.dirA.value} a ${this.dirB.value}: " + String.format("%.2f", result / 1000) + " km"
    }

    private fun checkDirections(dirA : String, dirB : String) : Boolean{
        var ok = true
        if(dirA.isNullOrEmpty() || dirB.isNullOrEmpty()){
            Snackbar.make(view, "No puede haber una direccion vacia", Snackbar.LENGTH_SHORT).show()
            ok = false
        }
        return ok
    }

    //----------------------------------- OTROS ---------------------------------------------
    //--> Esconde el keyboard (este metodo se creó principalmente para que se muestre el snackbar)
    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }


}