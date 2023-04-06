package com.example.drawingapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    private  var drawingView: DrawingView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawingView = findViewById(R.id.drawing_view)
        drawingView?.setBrushSize(4f)

        val imageButtonBrush: ImageButton = findViewById(R.id.image_button_brush)
        imageButtonBrush.setOnClickListener {
            showBrushSizeDialog()
        }
    }

    private fun showBrushSizeDialog()
    {
        val brushDialog = Dialog(this)

        brushDialog.setContentView(R.layout.brush_size_dialog)
        brushDialog.setTitle("Brush Size : ")

        val smallButton = brushDialog.findViewById<ImageButton>(R.id.image_button_small_brush)
        val mediumButton = brushDialog.findViewById<ImageButton>(R.id.image_button_medium_brush)
        val largeButton = brushDialog.findViewById<ImageButton>(R.id.image_button_large_brush)

        smallButton.setOnClickListener{
            drawingView?.setBrushSize(10f)
            brushDialog.dismiss()
        }
        mediumButton.setOnClickListener{
            drawingView?.setBrushSize(15f)
            brushDialog.dismiss()
        }
        largeButton.setOnClickListener{
            drawingView?.setBrushSize(20f)
            brushDialog.dismiss()
        }


        brushDialog.show()

    }
}