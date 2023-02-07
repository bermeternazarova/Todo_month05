package com.example.todo_month05.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
@Insert
fun insertTask(task: Task)
@Query("SELECT * FROM task ")
fun getTasks():List<Task>
@Delete
fun deleteTask(task: Task)

    @Query("SELECT * FROM Task ORDER BY task Asc")
    fun sortedByAlphabet():List<Task>
}