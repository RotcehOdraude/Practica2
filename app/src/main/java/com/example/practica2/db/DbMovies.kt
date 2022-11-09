package com.example.practica2.db

import android.content.ContentValues
import android.content.Context

class DbMovies(private val context:Context):DbHelper(context) {
    //Esta clase implementa las opreaciones CRUD
    public fun insertMovie(titulo:String,genero:String,anio:Int,valoracion:Int):Long{
        val dbHelper = DbHelper(context)
        val db = dbHelper.writableDatabase

        var id:Long = 0

        try {
            val values = ContentValues()
            values.put("titulo",titulo)
            values.put("genero",genero)
            values.put("anio",anio)
            values.put("valoracion",valoracion)

            db.insert("movies",null, values)
        }catch (e:Exception){
            //Manejo de excepciones
        }finally {
            db.close()
        }

        return id
    }
}