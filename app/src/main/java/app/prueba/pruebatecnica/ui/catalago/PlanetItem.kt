package app.prueba.pruebatecnica.ui.catalago

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.prueba.pruebatecnica.domain.model.Planet

@Composable
fun PlanetItem (planet: Planet, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(12.dp)
    ) {
        Icon(
            imageVector = Icons.Default.AccountBox,
            contentDescription = "Planet icon",
            modifier = Modifier
                .size(64.dp)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            planet.name?.let { Text(text = it, style = MaterialTheme.typography.titleMedium) }
            Text(text = "Climate: ${planet.climate}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Terrain: ${planet.terrain}", style = MaterialTheme.typography.bodySmall)
        }
    }
}

fun onClick() {
    TODO("Not yet implemented")
}
