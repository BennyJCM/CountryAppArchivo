package dev.bcarrera.countryapp


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun RegisterScreen(navController: NavController) {
    // Estado para los campos de nombre, correo, contraseña y confirmar contraseña
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue("")) }

    // Columnas de la interfaz
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Título del formulario
        Spacer(modifier = Modifier.height(80.dp)) // Espacio superior
        Text("Registro", style = MaterialTheme.typography.headlineLarge)

        // Campo de nombre
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de correo electrónico
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de confirmar contraseña
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirmar contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        // Botón de registro
        Button(
            onClick = {
                // Lógica simple para la validación del formulario
                if (name.text.isNotEmpty() && email.text.isNotEmpty() && password.text.isNotEmpty() && password.text == confirmPassword.text) {
                    // Si los campos no están vacíos y las contraseñas coinciden, navegar al login
                    navController.navigate("login")
                } else {
                    // Aquí podrías mostrar algún mensaje de error si las contraseñas no coinciden
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrarse")
        }

        // Opcional: mensaje de navegación a la pantalla de login
        TextButton(onClick = { navController.navigate("login") }) {
            Text("Ya tienes cuenta? Inicia sesión")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreen() {
    RegisterScreen(navController = rememberNavController())
}