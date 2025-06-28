package app.prueba.pruebatecnica.ui.catalago

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.prueba.pruebatecnica.domain.model.Planet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanetDetailScreen(planet: Planet) {
    Scaffold(
        topBar = {
            TopAppBar(title = { planet.name?.let { Text(text = it) } })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Name: ${planet.name}", style = MaterialTheme.typography.titleLarge)
            Text(text = "Climate: ${planet.climate}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Terrain: ${planet.terrain}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Population: ${planet.population}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}