package com.example.task3.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp

import androidx.navigation.NavHostController
import com.example.task3.OtherComposables.*


import com.example.task3.database.User
import com.example.task3.database.UserViewmodel
import com.example.task3.navigation.TopLevel
import kotlin.random.Random


@Composable
fun ScreenB(navController: NavHostController, viewmodel: UserViewmodel) {

    Scaffold(modifier = Modifier.fillMaxSize()) {paddingValues ->

        val users= remember {
            viewmodel._users
        }.collectAsState()
        LaunchedEffect(key1 ="Unit" ){
            viewmodel.getUsers()
        }
        Column(modifier = Modifier
            .padding(paddingValues)
        ) {
            TopBar(canGoBack = false)
            TitleText(text = "Welcome to user list screen")
            users.value?.let {list->
                listUi(users = list, onClick = {
                    viewmodel.getUserById(it.userId)
                    println(""+viewmodel._currentUser.value)
                    navController.navigate(TopLevel.C.path)
                })
            }

            CustomButton("Add A User",onClick = {
                viewmodel.addUser(generateUser()) })
        }
    }
}

@Composable
fun listUi(users:List<User>, onClick: (User)->Unit){
    LazyColumn(modifier = Modifier.fillMaxWidth().height(550.dp), verticalArrangement = Arrangement.spacedBy(15.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        items(users) { user ->
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .border(2.dp, Color.Black, RoundedCornerShape(10.dp))
                    .padding(10.dp)
                    .clickable {
                        onClick.invoke(user)
                    }
            ) {
                Column() {
                    Row() {
                        CustomText(text = "UserId :${user.userId}",15f)
                        HorizontalSpacer(value = 60)
                        CustomText(text = "UserName :${user.userName}",15f)
                    }
                    CustomText(text = "FullName :${user.fullName}",15f)
                    CustomText(text = "Email :${user.email}",15f)
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(26.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Black, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "${users.indexOf(user)+1}")
                }
            }

        }
    }
}


fun generateUser():User{
    val alphanumeric : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    val alpha= ('a'..'z') + ' '
    return User(Random.nextLong(100000,999999), randomString(6,alphanumeric),
        randomString(20,alpha),randomString(10,alphanumeric,"@gmail.com"))
}
fun randomString(size:Int,charPool:List<Char>,format:String?=null):String{
    var str= (1..size)
        .map { Random.nextInt(0, charPool.size).let { charPool[it] } }.joinToString("")
    format?.let{
        str += format
    }
    return str
}