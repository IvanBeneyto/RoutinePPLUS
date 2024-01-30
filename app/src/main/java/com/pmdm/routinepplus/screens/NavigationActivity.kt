package com.pmdm.routinepplus.screens

sealed class NavigationActivity (val route:String) {
    object LoginScreenMain: NavigationActivity("Login")
    object Dashboard: NavigationActivity("DashboardScreen/{username}/{password}")
}