package app.prueba.pruebatecnica.ui.catalago

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogoActivity  : ComponentActivity() {
    private val viewModel: CatalogoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            CatalogoScreen()

        }
    }
}