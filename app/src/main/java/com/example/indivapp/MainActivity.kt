package com.example.indivapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.indivapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.supportActionBar?.hide() // hides the toolbar from home page

        binding.toDoButton.setOnClickListener { navToToDo() }
        binding.petLogButton.setOnClickListener { navToPetLog() }

    }

    private fun navToToDo(){
        // go to the to-do page
        val intent: Intent = Intent(this, ToDoListActivity::class.java)
        startActivity(intent)
    }

    private fun navToPetLog(){
        // go to the pet log page
        val intent: Intent = Intent(this, PetLogActivity::class.java)
        startActivity(intent)

    }
}