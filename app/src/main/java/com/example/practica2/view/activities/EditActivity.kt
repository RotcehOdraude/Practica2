package com.example.practica2.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.practica2.R
import com.example.practica2.databinding.ActivityEditBinding
import com.example.practica2.db.DbMovies
import com.example.practica2.model.Movie

class EditActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityEditBinding

    private lateinit var dbMovies: DbMovies
    var movie: Movie? = null
    private var movieString = ""
    var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        print("El id es $id")
        if(bundle!=null){
            id = bundle.getInt("ID",0)

        }

        dbMovies = DbMovies(this)
        movie = dbMovies.getMovie(id)

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

        movie?.let{
            with(binding){
                tietTitulo.setText(it.titulo)
                seleccionarOpcion(spinner,it.genero)
                tietAnio.setText(it.anio.toString())
                tietValoracion.setText(it.valoracion.toString())

                //desactivar teclado
                //tietTitulo.inputType = InputType.TYPE_NULL
                //tietGenero.inputType = InputType.TYPE_NULL
                //tietAnio.inputType = InputType.TYPE_NULL
                //tietValoracion.inputType = InputType.TYPE_NULL
            }
        }
    }

    fun click(view: View) {
        /*with(binding){
            when{
                tietTitle.text.toString().isEmpty() -> {
                    tietTitle.error = "No puede quedar vacío"
                    Toast.makeText(this@EditActivity, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
                }
                tietGenre.text.toString().isEmpty() -> {
                    tietGenre.error = "No puede quedar vacío"
                    Toast.makeText(this@EditActivity, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
                }
                tietDeveloper.text.toString().isEmpty() -> {
                    tietDeveloper.error = "No puede quedar vacío"
                    Toast.makeText(this@EditActivity, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    if(dbGames.updateGame(id, tietTitle.text.toString(), tietGenre.text.toString(), tietDeveloper.text.toString())){
                        Toast.makeText(this@EditActivity, "Registro actualizado exitosamente", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@EditActivity, DetailsActivity::class.java)
                        intent.putExtra("ID", id)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this@EditActivity, "Error al actualizar el registro", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }*/
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        //startActivity(Intent(this, DetailsActivity::class.java))
        //finish()
    }

    fun seleccionarOpcion(spinner: Spinner, cadena: String) {
        val adapter = spinner.adapter as ArrayAdapter<String>
        for (i in 0 until adapter.count) {
            if (adapter.getItem(i) == cadena) {
                spinner.setSelection(i)
                break
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        movieString = parent.getItemAtPosition(pos).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}