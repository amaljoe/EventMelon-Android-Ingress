package com.devex.eventmelon

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.devex.eventmelon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
        const val TOKEN = "token"
        const val SHARED_PREFS_FILE = "com.devex.eventmelon.shared_prefs"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Set night mode to false
         */
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        /**
         * Binding the views
         */
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Setup navigation and connect with bottom navigation bar, toolbar and fragments
         */
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.bottom_nav_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        // TODO: change no connection to explore fragment. Also change in navigation xml.
        val topLevelDestinations = setOf(R.id.homeFragment, R.id.noConnectionFragment, R.id.socialFragment, R.id.profileFragment)
        val appBarConfiguration = AppBarConfiguration.Builder(topLevelDestinations).build()
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.bottomNavBar.setupWithNavController(navController)

        /**
         * Show toolbar and bottom navigation only on top level destinations(main screens)
         */
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id in topLevelDestinations) {
                binding.bottomNavBar.visibility = View.VISIBLE
                binding.toolbar.visibility = View.VISIBLE
            } else {
                binding.bottomNavBar.visibility = View.GONE
                binding.toolbar.visibility = View.GONE
            }
        }


        /**
         * Check if the user is logged in, if not navigate to login activity
         */
        val sharedPref = this.getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE)
        val token: String? = sharedPref.getString(TOKEN, null)
        if(token == null) {
            Log.d(TAG, "token is null")
            val loginIntent = Intent(this, LoginActivity::class.java)
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(loginIntent)
        }

    }
}