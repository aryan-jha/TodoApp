package com.example.todoapp

import java.time.Instant
import java.util.Date

data class Todo(

    val id: Int,
    val title: String,
    val createdAt : Date
)

fun getTodo() : List<Todo>{
    return listOf(
        Todo(1, "Todo 1", Date.from(Instant.now())),
        Todo(2, "Todo 1", Date.from(Instant.now())),
        Todo(3, "Todo 1", Date.from(Instant.now()))


    )
}