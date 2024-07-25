package com.example.todoapp

import java.time.Instant
import java.util.Date

object TodoManager {

    private val todolist = mutableListOf<Todo>()

    fun addTask(title : String){
        todolist.add(Todo(System.currentTimeMillis().toInt(), title, Date.from(Instant.now())))
    }

    fun deleteTask(id : Int){

        todolist.removeIf{
            it.id == id
        }

    }
    fun getAllTask() : List<Todo>{
        return todolist
    }

}