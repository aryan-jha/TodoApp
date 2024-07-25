package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel(){

    private val _todoList = MutableLiveData<List<Todo>>()
    val todoList : LiveData<List<Todo>> = _todoList

    fun addTask(title : String){
        TodoManager.addTask(title)
        getAllTask()
    }

    fun deleteTask(id : Int){
        TodoManager.deleteTask(id)
        getAllTask()
    }
    fun getAllTask(){
        _todoList.value = TodoManager.getAllTask().reversed()
    }



}