package com.example.drawingapp

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    private var drawingView: DrawingView? = null
    private var mImageButtonCurrentPaint: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawingView = findViewById(R.id.drawing_view)
        drawingView?.setBrushSize(4f)

        val linearLayoutPaintColors = findViewById<LinearLayout>(R.id.linear_layout_paint_colors)

        mImageButtonCurrentPaint = linearLayoutPaintColors[2] as ImageButton
        mImageButtonCurrentPaint!!.setImageDrawable(
            ContextCompat.getDrawable(this,R.drawable.palette_selected)
        )

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
       brushDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        brushDialog.show()

    }

    fun colorClicked(view: View)
    {
        if (view !== mImageButtonCurrentPaint)
        {
            val imageButton = view as ImageButton
            val colorTag = imageButton.tag.toString()

            drawingView?.setColor(colorTag)

            imageButton.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.palette_selected)
            )
            mImageButtonCurrentPaint?.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.palette_normal)
            )
        }

       // Toast.makeText(this,"Clicked ----- yo",Toast.LENGTH_SHORT).show()
    }
}