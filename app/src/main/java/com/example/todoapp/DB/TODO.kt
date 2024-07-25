package com.example.todoapp.DB

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class TODO(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title : String,
    val createdAt : Date

)
