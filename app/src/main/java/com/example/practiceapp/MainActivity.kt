package com.example.practiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rvTodo: RecyclerView = findViewById(R.id.rvTodos)
        val etTodo: EditText = findViewById(R.id.etTodo)
        val btnAddTodo: Button = findViewById(R.id.btnAddTodo)

        var todoList = mutableListOf<Todo>(
            Todo("Android development is fun", false),
            Todo("Android development is not easy", false),
            Todo("I am a new programmer", true),
            Todo("Android development is fun", false),
            Todo("My younger daughter name is Tithi", true),
            Todo("My older daughter name is Shithi", false),
            Todo("Punam is my wife", true),
            Todo("Android development is fun", false),
            Todo("Android development is fun", false),
            Todo("Android development is fun", false),
        )
        val adapter = TodoAdapter(todoList)
        rvTodo.adapter = adapter
        rvTodo.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        }

    }
}