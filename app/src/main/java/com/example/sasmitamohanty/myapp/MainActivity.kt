package com.example.sasmitamohanty.myapp

import android.content.Intent
import android.hardware.camera2.CaptureFailure
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import kotlinx.android.synthetic.main.capture1.*
class MainActivity : AppCompatActivity()
{
    var startButton: Button?= null
    var captureButton: Button?= null
    var pickButton: Button?= null


    override fun  onCreate( savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.captureFile)
        startButton?.setOnClickListener{
            var clickIntent= Intent(this@MainActivity, captureFile::class.java)
            startActivity(clickIntent)
        }

        setContentView(R.layout.capture1)
        captureButton = findViewById(R.id.btncamera)
        val request_image_capture = 1
        captureButton?.setOnClickListener{
            fun dispatchTakePictureIntent()
            {
                Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                    takePictureIntent.resolveActivity(packageManager)?.also {
                        startActivityForResult(takePictureIntent, request_image_capture)
                    }
                }
            }
        }
        val pick_image = 1
        pickButton = findViewById(R.id.button2)
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "pickButton"), pick_image)






    }
}


