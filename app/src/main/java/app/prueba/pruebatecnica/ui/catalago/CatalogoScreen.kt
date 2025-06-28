package app.prueba.pruebatecnica.ui.catalago

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogoScreen(viewModel: CatalogoViewModel = hiltViewModel()) {
    val planets by viewModel.planets.observeAsState(emptyList())
    val errorMessage by viewModel.errorMessage.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.getPlanets()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Catálogo de Planetas") },
               modifier = Modifier.background(Color.Blue)
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(16.dp)) {
            if (errorMessage != null) {
                Text(text = "Error: $errorMessage", color = Color.Red)
            }

            if (planets?.isEmpty() == true) {
                CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
            } else {
                planets?.forEach { planet ->
                    PlanetItem(planet = planet, onClick = {})
                }
            }
        }

    }

}