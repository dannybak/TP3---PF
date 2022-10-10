package com.example.scalonetaapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.bumptech.glide.Glide
import com.example.scalonetaapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavView : BottomNavigationView
    private lateinit var navHostFragment : NavHostFragment

    /** --> Texto que da la bienvenida cuando la persona se loguea
    lateinit var usernameTextView : TextView
    lateinit var receiveUsername : String
     */

    private lateinit var argentinaFlag : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        argentinaFlag = findViewById(R.id.argentinaFlag)
        Glide
            .with(this)
            .load("https://logodownload.org/wp-content/uploads/2022/06/bandeira-argentina-flag-1.png")
            .into(argentinaFlag);

        //usernameTextView = findViewById(R.id.username)

        /**
        receiveUsername = MainActivityArgs.fromBundle(requireArguments()).username

        val text = "Bienvenido $receiveUsername"
        usernameTextView.text = text

         **/

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        bottomNavView = findViewById(R.id.bottom_navigation)
        NavigationUI.setupWithNavController(bottomNavView, navHostFragment.navController)
    }
}