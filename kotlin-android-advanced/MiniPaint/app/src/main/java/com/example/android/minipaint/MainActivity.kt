package com.example.android.minipaint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //store in bitmap
        val myCanvasView = MyCanvasView(this)
        myCanvasView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
        myCanvasView.contentDescription = getString(R.string.canvasContentDescription)

        //using path without bitmap
        val myCanvasView2 = MyCanvasView2(this)
        myCanvasView2.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
        myCanvasView2.contentDescription = getString(R.string.canvasContentDescription)

        setContentView(myCanvasView2)

    }
}