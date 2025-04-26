package dev.bcarrera.countryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.bcarrera.countryapp.ui.theme.CountryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountryAppTheme {
                // Configuración de navegación
                CountryAppNavigation()
            }
        }
    }
}

@Composable
fun CountryAppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "register") {
        composable("register") { RegisterScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("countryList") { CountryListScreen() }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CountryAppTheme {
        Greeting("Android")
    }
}