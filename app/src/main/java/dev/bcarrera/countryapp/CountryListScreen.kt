package dev.bcarrera.countryapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import dev.bcarrera.countryapp.ui.theme.CountryAppTheme

data class Country(val name: String, val fifaRanking: Int, val flag: Int)

@Composable
fun CountryListScreen() {
    val countries = listOf(
        Country("Argentina", 1, R.drawable.argentina_flag),
        Country("Brazil", 2, R.drawable.brazil_flag),
        Country("France", 3, R.drawable.france_flag)
    )
    Spacer(modifier = Modifier.height(80.dp))  // Esto mueve el título hacia abajo

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(countries) { country ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = country.flag),
                        contentDescription = "${country.name} flag",
                        modifier = Modifier.size(50.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(text = country.name, style = MaterialTheme.typography.bodyLarge)
                        Text(text = "FIFA Ranking: ${country.fifaRanking}")
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