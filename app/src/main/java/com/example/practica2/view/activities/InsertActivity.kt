package com.example.practica2.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.practica2.R
import com.example.practica2.databinding.ActivityInsertBinding
import com.example.practica2.db.DbMovies

class InsertActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding:ActivityInsertBinding
    private var movie = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
        binding = ActivityInsertBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinner: Spinner = binding.spGenero
        spinner.onItemSelectedListener = this
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.generos_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
            //spinner.setSelection(adapter.getPosition("Terror"))
        }

    }

    fun click(view: View) {
        val dbMovies = DbMovies(this)
        with(binding){
            when{
                tietTitulo.text.toString().isEmpty() -> {
                    tietTitulo.error = "No puede quedar vacío"
                    Toast.makeText(this@InsertActivity, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
                }
                /*spGenero.text.toString().isEmpty() -> {
                    tietGenero.error = "No puede quedar vacío"
                    Toast.makeText(this@InsertActivity, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
                }*/
                tietAnio.text.toString().isEmpty() -> {
                    tietAnio.error = "No puede quedar vacío"
                    Toast.makeText(this@InsertActivity, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
                }
                tietValoracion.text.toString().isEmpty() -> {
                    tietValoracion.error = "No puede quedar vacío"
                    Toast.makeText(this@InsertActivity, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
                }else -> {
                    //Realizamos la inserción
                    val id = dbMovies.insertMovie(tietTitulo.text.toString(), movie,tietAnio.text.toString().toInt(),tietValoracion.text.toString().toInt())
                    if(id>0){
                        Toast.makeText(this@InsertActivity, "Registro guardado exitosamente", Toast.LENGTH_SHORT).show()
                        tietTitulo.setText("")
                        //tietGenero.setText("")
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

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        //movie tiene el string de la opción seleccionada en el spinner
        movie = parent.getItemAtPosition(pos).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}