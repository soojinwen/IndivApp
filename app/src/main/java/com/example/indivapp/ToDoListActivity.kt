package com.example.indivapp

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
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

    public var permissionGranted = false
    public val permissionCode = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityToDoListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.supportActionBar?.hide() // hides the toolbar from home page

        binding.backButton.setOnClickListener { navToHome() }
        checkPermissions()
        binding.cameraButton.setOnClickListener {
            if (permissionGranted) {
                openCamera()
            }
            else {
                Toast.makeText(this,"No Permission", Toast.LENGTH_LONG).show()
            }
        }

    }

    fun checkPermissions(){
        val camera = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)

        if (camera == PackageManager.PERMISSION_GRANTED){
            permissionGranted = true
        }
        else {
            makeRequest()
        }
    }

    fun makeRequest(){
        val camera = Manifest.permission.CAMERA

        ActivityCompat.requestPermissions(this, arrayOf(camera), permissionCode)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            permissionGranted = true
        }
    }

    private fun navToHome(){
        // go to the home page
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun openCamera(){
        // open Camera
        val openCameraIntent: Intent = Intent(this, AddPhotoActivity::class.java)
        startActivity(openCameraIntent)
    }

}