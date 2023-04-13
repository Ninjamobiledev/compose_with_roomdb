package com.example.task3.dagger

import android.content.Context
import androidx.room.Database
import androidx.room.Room

import com.example.task3.Preferences.Preferences
import com.example.task3.database.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): UserDatabase {
        return Room.databaseBuilder(context, UserDatabase::class.java, "Users").build()
    }

    @Provides
    fun provideDao(db: UserDatabase) = db.getUserDao()

    @Provides
    fun providePreference(@ApplicationContext context: Context): Preferences {
        return Preferences(context)
    }
}