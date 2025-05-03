package dev.bcarrera.countryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.bcarrera.countryapp.presentation.auth.LoginScreen
import dev.bcarrera.countryapp.presentation.auth.RegisterScreen
import dev.bcarrera.countryapp.presentation.home.CountryListScreen
import dev.bcarrera.countryapp.presentation.navigation.NavigationMenu
import dev.bcarrera.countryapp.ui.theme.CountryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountryAppTheme {
                // Configuración de navegación
                NavigationMenu()
            }
        }
    }
}



@Composable
fun GreetingPreview() {
    CountryAppTheme {
        Greeting("Android")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}