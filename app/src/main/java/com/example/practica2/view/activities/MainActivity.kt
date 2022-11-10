package com.example.practica2.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practica2.databinding.ActivityMainBinding
import com.example.practica2.db.DbMovies
import com.example.practica2.model.Movie
import com.example.practica2.view.adapters.MoviesAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var listMovies: ArrayList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbMovies = DbMovies(this)
        listMovies = dbMovies.getMovies()
        val moviesAdapter = MoviesAdapter(this,listMovies)
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = moviesAdapter
    }

    fun click(view: View) {
        startActivity(Intent(this,InsertActivity::class.java))
        finish()
    }

    fun selectedMovie(movie: Movie){
        //Manejamos el click del elemento en el recycler view
        val intent = Intent(this,DetailsActivity::class.java )
        Log.d("ayuda", movie.id.toString());
        intent.putExtra("ID",movie.id)
        startActivity(intent)
        finish()
    }
}