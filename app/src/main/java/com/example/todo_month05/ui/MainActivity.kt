package com.example.todo_month05.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.todo_month05.data.local.Task
import com.example.todo_month05.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
   private val viewModel :MainViewModel  by viewModels()
    private lateinit var adapterMain: AdapterMain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
        initListeners()
        observers()
    }

    private fun onClick(task: Task) {
        viewModel.deleteTask(task)
    }

    private fun initialize() {
        adapterMain =AdapterMain(this::onClick)
        binding.rvTodo.adapter = adapterMain
        viewModel.getAllTask()
    }
    private fun observers() {
        viewModel.tasks.observe(this){
            binding.refreshLayout.isRefreshing = false
            adapterMain.updateLIst(it)
        }
        viewModel.event.observe(this){
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        }
    }
    private fun initListeners() {
        binding.btnTodo.setOnClickListener {
        viewModel.insertTask(binding.etTodo.text.toString())}
        binding.refreshLayout.setOnRefreshListener {
            viewModel.getAllTask()
        }
        binding.btnClearAll.setOnClickListener {
         viewModel.deleteAllTask()
        }
        binding.btnSorted.setOnClickListener {
            viewModel.sorted()
        }
}
}