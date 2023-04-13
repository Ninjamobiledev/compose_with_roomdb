package com.example.task3.database

import androidx.room.*

@Database(entities = [User::class], exportSchema = true, version = 1)
abstract class UserDatabase: RoomDatabase(){
    abstract fun getUserDao():UserDao
}
@Entity(tableName = "Users")
data class User (@PrimaryKey val userId:Long,
                 @ColumnInfo(name = "user_name") val userName: String,
                 @ColumnInfo(name = "full_name") val fullName: String,
                 val email:String)