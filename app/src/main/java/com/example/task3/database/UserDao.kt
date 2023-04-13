package com.example.task3.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: User):Long
    @Insert
    suspend fun addUsers(user: List<User>)

    @Query("SELECT * FROM Users")
    fun getUsers(): Flow<List<User>>
    @Query("SELECT * FROM Users WHERE userId=:id ")
    suspend fun getUsersById(id: Long): User
}