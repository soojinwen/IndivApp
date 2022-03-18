package com.example.indivapp

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.indivapp.databinding.ActivityToDoListBinding

class ToDoListActivity : AppCompatActivity() {

    lateinit var binding: ActivityToDoListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityToDoListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.supportActionBar?.hide() // hides the toolbar from home page

        binding.backButton.setOnClickListener { navToHome() }
        binding.cameraButton.setOnClickListener { navToCamera() }
    }

    private fun navToHome(){
        // go to the home page
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun navToCamera(){
        // go to the add photo page
        val intent: Intent = Intent(this, AddPhotoActivity::class.java)
        startActivity(intent)
    }
}