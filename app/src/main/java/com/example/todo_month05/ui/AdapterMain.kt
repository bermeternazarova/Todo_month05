package com.example.todo_month05.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_month05.convertLongToTime
import com.example.todo_month05.data.local.Task
import com.example.todo_month05.databinding.ItemTodoBinding

  class AdapterMain (private val click:(Task)->Unit):RecyclerView.Adapter<AdapterMain.ViewHolderMain> (){
    private var task = ArrayList<Task>()

    fun updateLIst(task:List<Task>) {
        this.task = task as ArrayList<Task>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMain {
        return ViewHolderMain(ItemTodoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: ViewHolderMain, position: Int) {
        holder.bind(task[position])
        holder.itemView.setOnClickListener {
            click(task[position])
        }
    }

    override fun getItemCount(): Int {
        return  task.size }

    inner class ViewHolderMain(private val binding: ItemTodoBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(task: Task) {
            binding.itemTv.text = task.task
            binding.itemTime.text = task.time.convertLongToTime()
        } }
}