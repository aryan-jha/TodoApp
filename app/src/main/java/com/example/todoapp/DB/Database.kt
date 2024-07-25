package com.example.todoapp.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [TODO::class], version = 1)
@TypeConverters(Converters::class)
abstract class Database : RoomDatabase() {

    companion object{
        const val Name = "todo_db"
    }

    abstract fun getDao():TodoDao

}