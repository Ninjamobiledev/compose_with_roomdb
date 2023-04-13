package com.example.task3.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

import com.example.task3.OtherComposables.CustomText
import com.example.task3.OtherComposables.TitleText
import com.example.task3.OtherComposables.TopBar
import com.example.task3.OtherComposables.VerticalSpacer
import com.example.task3.database.UserViewmodel

@Composable
fun ScreenC(navController: NavHostController, viewmodel: UserViewmodel) {
    val user= remember {
        viewmodel._currentUser
    }.collectAsState()



    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            TopBar(canGoBack = true){
                navController.popBackStack()
            }
            TitleText(text = "Welcome to user detail screen",)
            user.value?.let {user->
                Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
                    CustomText(text = "UserId :${user.userId}",20f)
                    VerticalSpacer(value = 8)
                    CustomText(text = "UserName :${user.userName}",20f)
                    VerticalSpacer(value = 8)
                    CustomText(text = "FullName :${user.fullName}",20f)
                    VerticalSpacer(value = 8)
                    CustomText(text = "Email :${user.email}",20f)
                }
            }

        }
    }
}