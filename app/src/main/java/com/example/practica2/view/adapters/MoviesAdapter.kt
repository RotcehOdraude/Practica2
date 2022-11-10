package com.example.practica2.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practica2.R
import com.example.practica2.databinding.ListElementBinding
import com.example.practica2.model.Movie
import com.example.practica2.view.activities.MainActivity

class MoviesAdapter(private val context: Context, private val movies: ArrayList<Movie>): RecyclerView.Adapter<MoviesAdapter.ViewHolder>(){

    private val layoutInflater = LayoutInflater.from(context)

    class ViewHolder(view: ListElementBinding): RecyclerView.ViewHolder(view.root){
        val tvTitulo = view.tvTitulo
        val tvGenero = view.tvGenero
        val tvAnio = view.tvAnio
        val tvValoracion = view.tvValoracion
        val imageView = view.imageView
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
        if (movies[position].genero == "Animacion"){
            holder.imageView.setImageResource(R.drawable.animacion)
        }else if (movies[position].genero == "Comedia"){
            holder.imageView.setImageResource(R.drawable.comedia)
        }else if (movies[position].genero == "Drama"){
            holder.imageView.setImageResource(R.drawable.drama)
        }else if (movies[position].genero == "Romance"){
            holder.imageView.setImageResource(R.drawable.romance)
        }else if (movies[position].genero == "Terror"){
            holder.imageView.setImageResource(R.drawable.terror)
        }


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