package com.example.task3.Preferences

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.preference by preferencesDataStore("My_Datastore")
class Preferences(@ApplicationContext val context: Context){
    val GROUP_CREATE= booleanPreferencesKey("group create")
    suspend fun saveData(shouldCreate:Boolean){
        context.preference.edit { mutablePreferences ->
            mutablePreferences[GROUP_CREATE]=shouldCreate
        }
    }
    fun getData():Flow<Boolean>{
        return context.preference.data.map {
            it[GROUP_CREATE]?:true
        }
    }
}