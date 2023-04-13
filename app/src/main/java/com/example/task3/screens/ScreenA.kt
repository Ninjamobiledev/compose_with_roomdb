package com.example.task3.screens

import com.example.task3.OtherComposables.CustomButton
import com.example.task3.OtherComposables.TopBar
import com.example.task3.database.User
import com.example.task3.database.UserViewmodel
import com.example.task3.navigation.TopLevel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController


@Composable
fun ScreenA(navController: NavHostController, viewmodel: UserViewmodel) {
    val list = mutableListOf<User>()
    (1..5).forEach {
        list.add(generateUser())
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
        ) {
            TopBar(canGoBack = false)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomButton("Add All Users", onClick = {
                    navController.navigate(TopLevel.B.path){
                        popUpTo(TopLevel.A.path){inclusive=true}
                    }
                    viewmodel.addUsers(list)
                    })
            }

        }
    }
}