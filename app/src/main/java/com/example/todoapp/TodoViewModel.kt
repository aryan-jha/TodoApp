package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.DB.TODO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoViewModel : ViewModel(){

    val todoDAOInstance = MainApplication.todoDatabase.getDao()

    val todoList: LiveData<List<TODO>> = todoDAOInstance.getAllTodo()


    fun addTask(title : String){

        viewModelScope.launch(Dispatchers.IO) {
            todoDAOInstance.insertTodo(com.example.todoapp.DB.TODO(title = title, createdAt = Date.from(Instant.now())))
        }

    }

    fun deleteTask(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            todoDAOInstance.deleteTodo(id = id)
        }
    }




}