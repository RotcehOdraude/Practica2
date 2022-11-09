package com.example.practica2.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DbHelper(context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "videogames.db"
        private const val TABLE_MOVIES = "movies"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_MOVIES (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL,genero TEXT NOT NULL, anio INTEGER NOT NULL, valoracion INTEGER NOT NULL)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE $TABLE_MOVIES")
        onCreate(db)
    }
}