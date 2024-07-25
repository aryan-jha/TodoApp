package com.example.todoapp.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {

    @Query("SELECT * FROM TODO")
    fun getAllTodo() : LiveData<List<TODO>>

    @Insert
    fun insertTodo(task : TODO)

    @Query("Delete FROM TODO WHERE id = :id")
    fun deleteTodo(id: Int)


}