package com.example.todo_month05.di

import android.content.Context
import androidx.room.Room
import com.example.todo_month05.data.local.AppDataBase
import com.example.todo_month05.data.local.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
     fun provideRoomDataBase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java,"TODO").allowMainThreadQueries().build()
    }
    @Provides
    fun userDao(appDataBase: AppDataBase): TaskDao = appDataBase.taskDao()
}