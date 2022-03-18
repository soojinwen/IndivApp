package com.example.indivapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.indivapp.databinding.ActivityPetLogBinding
import com.example.indivapp.databinding.ActivityToDoListBinding

class PetLogActivity : AppCompatActivity() {

    lateinit var binding: ActivityPetLogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPetLogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.supportActionBar?.hide() // hides the toolbar from home page

        binding.backButton2.setOnClickListener { navToHome() }
    }

    private fun navToHome(){
        // go to the home page
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}