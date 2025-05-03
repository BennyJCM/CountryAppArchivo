package dev.bcarrera.countryapp.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import coil.compose.rememberAsyncImagePainter

data class Country(val name: String, val ranking: Int, val flag: String)

@Composable
fun CountryListScreen() {

    // mock data
    val countries = listOf(
        Country("Argentina", 1, "https://flagcdn.com/w320/ar.png"),
        Country("Brasil", 2, "https://flagcdn.com/w320/br.png"),
        Country("Colombia", 3, "https://flagcdn.com/w320/co.png"),
        Country("España", 4, "https://flagcdn.com/w320/es.png"),
        Country("Francia", 5, "https://flagcdn.com/w320/fr.png"),
        Country("Inglaterra", 6, "https://flagcdn.com/w320/gb.png"),
    )

    Spacer(modifier = Modifier.height(80.dp))  // Esto mueve el título hacia abajo
    Text("Raning FIFA")

    LazyColumn{
        items(countries) { country ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(country.flag),
                        contentDescription = country.name,
                        modifier = Modifier.size(50.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(text = country.name, style = MaterialTheme.typography.titleMedium)
                        // Agregar "Ranking FIFA" con el ranking juntos
                        Text(text = "Ranking FIFA: ${country.ranking}", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCountryListScreen() {
    CountryListScreen()
}