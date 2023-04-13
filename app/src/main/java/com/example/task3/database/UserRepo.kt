package com.example.task3.database

import android.util.Log
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepo @Inject constructor(private val dao: UserDao){
    suspend fun addUsers(list:List<User>){
        try {
            dao.addUsers(list)
        }
        catch (e:Exception){
            Log.e("error",""+e.printStackTrace())
        }

    }
    suspend fun addUser(user: User){
        try {
            dao.addUser(user)
        }
        catch (e:Exception)
        {
            Log.e("error",""+e.printStackTrace())
        }
    }
    suspend fun getUsers(): Flow<List<User>> {
        return dao.getUsers()
    }

    suspend fun getUsersById(id:Long): User? {
        try {
            return dao.getUsersById(id)
        }
        catch (e:Exception){
            return null
        }
        return null
    }
}