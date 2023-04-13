package com.example.task3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController

import androidx.navigation.compose.rememberNavController

import com.example.task3.database.UserViewmodel
import com.example.task3.navigation.TopLevel
import com.example.task3.navigation.UserNavigation
import com.example.task3.ui.theme.Task3Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: UserViewmodel by viewModels()
        lifecycleScope.launchWhenResumed {
            val groupSave=viewModel.groupSave.value
            setContent {
                Task3Theme(){
                    val navController= rememberNavController()
                    Scaffold {padding->
                        if (groupSave){
                            UserNavigation(viewModel,navController = navController, modifier =Modifier.padding(padding),
                                TopLevel.A.path )
                            viewModel.saveGroupCreate(false)
                        }
                        else{
                            UserNavigation(viewModel,navController = navController, modifier =Modifier.padding(padding),TopLevel.B.path )
                        }
                    }
                }

            }

        }
    }


}