package com.example.practica2.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.practica2.model.Movie

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
    fun getMovies():ArrayList<Movie>{
        val dbHelper = DbHelper(context)
        val db = dbHelper.writableDatabase

        var listMovies = ArrayList<Movie>()
        var movieTmp:Movie? = null
        var cursorMovies:Cursor? = null

        cursorMovies = db.rawQuery("SELECT * FROM MOVIES",null)
        if(cursorMovies.moveToFirst()){
            do {
                movieTmp = Movie(cursorMovies.getInt(0),cursorMovies.getString(1),cursorMovies.getString(2),cursorMovies.getInt(3),cursorMovies.getInt(4))
                listMovies.add(movieTmp)
            }while(cursorMovies.moveToNext())
        }

        cursorMovies.close()

        return listMovies
    }
}