package com.example.todoapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun TodoListPage(viewModel: TodoViewModel) {

    val todoList by viewModel.todoList.observeAsState()
    var task by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            OutlinedTextField(
//                modifier = Modifier.weight(1f),
                value = task,

                onValueChange = {
                    task = it
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Text
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        if (task.isNotEmpty()) {
                            viewModel.addTask(task)
                            task = ""
                        }
                    }
                )
            )
            Button(onClick = {

                if (task.isNotEmpty()) {
                    viewModel.addTask(task)
                    task = ""
                }


            }) {
                Text(text = "Add")
            }
        }
        todoList?.let {
            LazyColumn(
                content = {
                    itemsIndexed(it) { index: Int, item: Todo ->

                        TodoItem(item = item, viewModel)


                    }
                }
            )
        } ?: Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "No items yet!",
            fontSize = 16.sp
        )


    }


}

@Composable
fun TodoItem(item: Todo,viewModel: TodoViewModel) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically


    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = SimpleDateFormat(
                    "HH:mm:ss:aa, dd/MM/yyyy",
                    Locale.getDefault()
                ).format(item.createdAt),
                fontSize = 12.sp,
                color = Color.White
            )

            Text(
                text = item.title,
                fontSize = 24.sp,
                color = Color.White
            )

        }

        IconButton(onClick = {
            viewModel.deleteTask(item.id)
        }) {
            Icon(
                imageVector = Icons.Default.Delete,
                tint = Color.White,
                contentDescription = null
            )
        }

    }

}