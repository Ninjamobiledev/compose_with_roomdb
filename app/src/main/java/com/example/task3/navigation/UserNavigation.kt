package com.example.task3.navigation

import com.example.task3.database.UserViewmodel
import com.example.task3.screens.ScreenA
import com.example.task3.screens.ScreenB
import com.example.task3.screens.ScreenC

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


sealed class TopLevel(val title:String,val path:String) {
    object A:TopLevel("","ScreenA")
    object B:TopLevel("Welcome To user List Screen","ScreenB")
    object C:TopLevel("Welcome to user detail Screen","ScreenC")
}
@Composable
fun UserNavigation(viewmodel: UserViewmodel, navController: NavHostController, modifier: Modifier, startDestination:String){

    NavHost(navController = navController,modifier=modifier, startDestination = startDestination) {

        composable(TopLevel.A.path) {
            ScreenA(navController,viewmodel)
        }
        composable(TopLevel.B.path) {
            ScreenB(navController,viewmodel)
        }
        composable(TopLevel.C.path) {
            ScreenC(navController,viewmodel)
        }
         }
}