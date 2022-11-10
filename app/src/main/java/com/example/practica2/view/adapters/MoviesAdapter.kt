package com.example.practica2.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practica2.databinding.ListElementBinding
import com.example.practica2.model.Movie
import com.example.practica2.view.activities.MainActivity

class MoviesAdapter(private val context: Context, val movies: ArrayList<Movie>): RecyclerView.Adapter<MoviesAdapter.ViewHolder>(){

    private val layoutInflater = LayoutInflater.from(context)

    class ViewHolder(view: ListElementBinding): RecyclerView.ViewHolder(view.root){
        val tvTitulo = view.tvTitulo
        val tvGenero = view.tvGenero
        val tvAnio = view.tvAnio
        val tvValoracion = view.tvValoracion
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListElementBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvTitulo.text = movies[position].titulo
        holder.tvGenero.text = movies[position].genero
        holder.tvAnio.text = movies[position].anio.toString()
        holder.tvValoracion.text = movies[position].valoracion.toString()


        //Para los clicks de cada elemento viewholder

        holder.itemView.setOnClickListener {
            //Manejar el click
            if(context is MainActivity) context.selectedMovie(movies[position])
        }

    }

    override fun getItemCount(): Int {
        return movies.size
    }

}