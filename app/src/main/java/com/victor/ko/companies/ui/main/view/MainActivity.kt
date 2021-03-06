package com.victor.ko.companies.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.victor.ko.companies.R
import com.victor.ko.companies.databinding.ActivityCompaniesBinding

class MainActivity  : AppCompatActivity() {

    private lateinit var bnd: ActivityCompaniesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bnd = ActivityCompaniesBinding.inflate(layoutInflater)
        setContentView(bnd.root)

        val navController = Navigation.findNavController(this, R.id.companies_nav_fragment)

        // Set up ActionBar
        setSupportActionBar(bnd.toolbar)
    }
}