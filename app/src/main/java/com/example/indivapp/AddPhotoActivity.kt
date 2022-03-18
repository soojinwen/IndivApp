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
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.indivapp.databinding.ActivityAddPhotoBinding
import com.example.indivapp.databinding.ActivityToDoListBinding

class AddPhotoActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddPhotoBinding

    var permissionGranted = false
    val permissionCode = 100
    val cameraResultCode = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.supportActionBar?.hide() // hides the toolbar from home page

        checkPermissions()
        binding.takePhotoButton.setOnClickListener {
            if (permissionGranted) {
                val openCameraIntent: Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(openCameraIntent, cameraResultCode)
            }
            else {
                Toast.makeText(this,"No Permission", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == cameraResultCode){
            if (resultCode == Activity.RESULT_OK) {
                val imageBitmap = data!!.extras!!.get("data") as Bitmap
                binding.picturePreview.setImageBitmap(imageBitmap)
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


}