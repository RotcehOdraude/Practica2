package com.example.practica2.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.practica2.R
import com.example.practica2.databinding.ActivityInsertBinding
import com.example.practica2.databinding.ActivityMainBinding

class InsertActivity : AppCompatActivity() {
    private lateinit var binding:ActivityInsertBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
        binding = ActivityInsertBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun click(view: View) {

    }
}