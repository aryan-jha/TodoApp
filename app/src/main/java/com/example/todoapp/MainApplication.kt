package com.example.todoapp

import android.app.Application
import androidx.room.Room
import com.example.todoapp.DB.Database

class MainApplication : Application() {

    companion object{
        lateinit var todoDatabase : Database
    }
    override fun onCreate() {
        super.onCreate()

        todoDatabase = Room.databaseBuilder(
            applicationContext,
            Database::class.java,
            Database.Name
        ).build()

    }

}