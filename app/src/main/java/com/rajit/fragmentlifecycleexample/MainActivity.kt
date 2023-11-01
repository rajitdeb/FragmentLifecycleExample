package com.rajit.fragmentlifecycleexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: $TAG onCreate() called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: $TAG onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: $TAG onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: $TAG onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: $TAG onStop() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: $TAG onRestart() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: $TAG onDestroy() called")
    }

}