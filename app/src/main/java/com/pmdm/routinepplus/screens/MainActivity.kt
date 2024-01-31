package com.pmdm.routinepplus.screens

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pmdm.routinepplus.ui.theme.RoutinePPLUSTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoutinePPLUSTheme {
                val navigationController = rememberNavController()


                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

                NavHost(
                    navController = navigationController,
                    startDestination = "loginScreen"
                ) {
                    composable("loginScreen"){ SingInScreen(navController = navigationController)}
                    composable("dashBoard"){ Dashboard(navigationController) }
                    composable("exercisesScreen"){ Exercises(navigationController) }
                }
            }
        }
    }
}
