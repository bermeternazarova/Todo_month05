package com.example.todo_month05.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo_month05.data.local.Task
import com.example.todo_month05.data.local.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val dao: TaskDao):ViewModel() {
    val tasks = MutableLiveData<List<Task>>().apply {
        value = ArrayList()
    }
    val event =MutableLiveData<String>()

    fun insertTask(task :String){
        if (task.isNotEmpty() &&task.isNotBlank())dao.insertTask(Task(task = task))
        else event.value = "Task is Empty!!!"
    }
    fun getAllTask(){
         tasks.value = dao.getTasks()
    }
    fun deleteTask(task: Task){
        dao.deleteTask(task)
    }
    fun deleteAllTask(){
        dao.deleteAll()
    }
    fun sorted(){
        dao.sortedByAlphabet()
    }
}