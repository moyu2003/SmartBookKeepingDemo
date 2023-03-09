package com.example.smartbookkeepingdemo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.smartbookkeepingdemo.R
import com.example.smartbookkeepingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.itemIconTintList = null;
        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController


        val configuration = AppBarConfiguration.Builder(binding.bottomNavigationView.menu).build()
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)
    }
}