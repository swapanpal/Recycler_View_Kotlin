package com.example.practiceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class TodoAdapter(
    var todos: List<Todo>
): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    // 1st
    inner class TodoViewHolder(itemview: View): RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent,false)
      return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
       return todos.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
    holder.itemView.apply {
        val title: TextView = findViewById(R.id.tvTitle)
        val isChecked: CheckBox = findViewById(R.id.cbDone)
        title.text = todos[position].title
        isChecked.isChecked = todos[position].isChecked
    }
    }
}