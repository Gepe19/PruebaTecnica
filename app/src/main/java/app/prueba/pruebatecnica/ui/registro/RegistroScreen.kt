package app.prueba.pruebatecnica.ui.registro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RegistroScreen (  viewModel: RegistroViewModel = hiltViewModel(),
                      onRegistroExitoso: () -> Unit) {
    val userForm by viewModel.userForm.collectAsState()

    val name = userForm.name
    val lastName = userForm.lastName
    val motherLastName = userForm.motherLastName
    val birthDate = userForm.birthDate
    val country = userForm.country
    val listaPaises = listOf("México", "Argentina", "Chile", "Colombia")
    var showDialog by remember { mutableStateOf(false) }

    Box (Modifier.fillMaxSize().background(Color.White).padding(top = 16.dp)){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Registro de Usuario",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            OutlinedTextField(
                value = name,
                onValueChange = { viewModel.onNameChange(it) },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = lastName,
                onValueChange = { viewModel.onLastNameChange(it) },
                label = { Text("Apellido Paterno") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = motherLastName,
                onValueChange = { viewModel.onMotherLastNameChange(it) },
                label = { Text("Apellido Materno") },
                modifier = Modifier.fillMaxWidth()
            )

            DatePDialog(
                fechaSeleccionada = birthDate,
                onFechaSeleccionada = { viewModel.onBirthDateChange(it) }
            )

            DropdownMenuPaises(
                selected = country,
                onPaisSelected = { viewModel.onCountryChange(it) },
                paises = listaPaises
            )

            Button (
                onClick = {
                    val validado = viewModel.validarCampos()
                    if (!validado) {
                        showDialog = true
                    } else {
                        viewModel.registrarUsuario {
                            onRegistroExitoso()
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Registrar Usuario")
            }
        }
        // AlertDialog cuando la validación falla
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Campos incompletos") },
                text = { Text("Es necesario capturar todos los campos.") },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Aceptar")
                    }
                }
            )
        }
    }

}