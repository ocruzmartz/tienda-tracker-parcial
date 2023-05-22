package com.ocruzmartz.tiendatracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ocruzmartz.tiendatracker.R
import com.ocruzmartz.tiendatracker.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}