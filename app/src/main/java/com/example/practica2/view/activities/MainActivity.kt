package com.example.practica2.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.practica2.databinding.ActivityMainBinding
import com.example.practica2.db.DbHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val dbHelper = DbHelper(this)
        val db = dbHelper.writableDatabase
        if(db!=null){
            Toast.makeText(this,"La BD fue creada exitosamente", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Error al crear la BD", Toast.LENGTH_SHORT).show()
        }*/
    }

    fun click(view: View) {
        startActivity(Intent(this,InsertActivity::class.java))
        finish()
    }
}