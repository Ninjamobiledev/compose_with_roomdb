package com.example.task3.database

import com.example.task3.Preferences.Preferences
 import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


@HiltViewModel
 class UserViewmodel @Inject constructor(val repo:UserRepo,val pref: Preferences) :ViewModel(){
    //for multiple users

    private val users = MutableStateFlow<List<User>>(emptyList())
    val _users = users.asStateFlow()
    //for single user
    private val currentUser = MutableStateFlow<User?>(null)
    val _currentUser = currentUser.asStateFlow()
    // for groupSave
    val groupSave=pref.getData().stateIn(viewModelScope, SharingStarted.Eagerly,true)

    fun addUsers(list: List<User>) = viewModelScope.launch{
        withContext(Dispatchers.IO){
            repo.addUsers(list)
        }
    }
    fun addUser(user:User) = viewModelScope.launch{
        withContext(Dispatchers.IO){
            repo.addUser(user)
        }

    }

    suspend fun getUsers(){
        repo.getUsers().collect{
            users.value=it
        }
    }

    fun getUserById(id: Long){
        viewModelScope.launch {
            val user=repo.getUsersById(id)
            user?.let {
                currentUser.value=user
            }
        }
    }
    fun saveGroupCreate(shouldCreate:Boolean){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                pref.saveData(shouldCreate)
            }

        }
    }
}