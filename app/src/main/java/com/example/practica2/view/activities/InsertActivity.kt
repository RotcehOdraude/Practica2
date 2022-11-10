package com.example.practica2.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.practica2.R
import com.example.practica2.databinding.ActivityInsertBinding
import com.example.practica2.db.DbMovies

class InsertActivity : AppCompatActivity() {
    private lateinit var binding:ActivityInsertBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
        binding = ActivityInsertBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun click(view: View) {
        val dbMovies = DbMovies(this)
        with(binding){
            when{
                tietTitulo.text.toString().isEmpty() -> {
                    tietTitulo.error = "No puede quedar vacío"
                    Toast.makeText(this@InsertActivity, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
                }
                tietGenero.text.toString().isEmpty() -> {
                    tietGenero.error = "No puede quedar vacío"
                    Toast.makeText(this@InsertActivity, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
                }
                tietAnio.text.toString().isEmpty() -> {
                    tietAnio.error = "No puede quedar vacío"
                    Toast.makeText(this@InsertActivity, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
                }
                tietValoracion.text.toString().isEmpty() -> {
                    tietAnio.error = "No puede quedar vacío"
                    Toast.makeText(this@InsertActivity, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
                }else -> {
                    //Realizamos la inserción
                    val id = dbMovies.insertMovie(tietTitulo.text.toString(), tietGenero.text.toString(),tietAnio.text.toString().toInt(),tietValoracion.text.toString().toInt())
                    if(id>0){
                        Toast.makeText(this@InsertActivity, "Registro guardado exitosamente", Toast.LENGTH_SHORT).show()
                        tietTitulo.setText("")
                        tietGenero.setText("")
                        tietAnio.setText("")
                        tietValoracion.setText("")
                        tietTitulo.requestFocus()
                    }else{
                        Toast.makeText(this@InsertActivity, "Error al guardar el registro", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
    }
}