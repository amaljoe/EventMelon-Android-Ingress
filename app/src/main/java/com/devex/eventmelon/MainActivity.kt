package com.devex.eventmelon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.devex.eventmelon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.bottom_nav_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val topLevelDestinations = setOf(R.id.homeFragment, R.id.exploreFragment, R.id.socialFragment, R.id.profileFragment)
        val appBarConfiguration = AppBarConfiguration.Builder(topLevelDestinations).build()
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.bottomNavBar.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id in topLevelDestinations) {
                binding.bottomNavBar.visibility = View.VISIBLE
                binding.toolbar.visibility = View.VISIBLE
            } else {
                binding.bottomNavBar.visibility = View.GONE
                binding.toolbar.visibility = View.GONE
            }
        }
    }
}