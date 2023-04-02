package com.example.practica2.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import com.example.practica2.R
import com.example.practica2.databinding.ActivityDetailsBinding
import com.example.practica2.db.DbMovies
import com.example.practica2.model.Movie

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    private lateinit var dbMovies: DbMovies
    var movie:Movie? = null
    var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras


        if(bundle!=null){
            id = bundle.getInt("ID",0)
        }

        dbMovies = DbMovies(this)
        movie = dbMovies.getMovie(id)

        movie?.let{
            with(binding){
                tietTitulo.setText(it.titulo)
                tietGenero.setText(it.genero)
                tietAnio.setText(it.anio.toString())
                tietValoracion.setText(it.valoracion.toString())

                //desactivar teclado
                tietTitulo.inputType = InputType.TYPE_NULL
                tietGenero.inputType = InputType.TYPE_NULL
                tietAnio.inputType = InputType.TYPE_NULL
                tietValoracion.inputType = InputType.TYPE_NULL
            }
        }
    }

    fun click(view: View) {
        when(view.id){
            R.id.btnEdit -> {
                val intent = Intent(this, EditActivity::class.java)
                intent.putExtra("ID", id)
                startActivity(intent)
                finish()
            }
            R.id.btnDelete -> {
                //Código para borrar el registro
                dbMovies.deleteMovie(id)
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
    }
}