package dev.bcarrera.countryapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.bcarrera.countryapp.presentation.auth.LoginScreen
import dev.bcarrera.countryapp.presentation.auth.RegisterScreen
import dev.bcarrera.countryapp.presentation.home.CountryListScreen

@Composable
fun NavigationMenu(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "register"){
        composable("register"){RegisterScreen(navController)}
        composable("login"){LoginScreen(navController)}
        composable("home"){CountryListScreen()}}
}