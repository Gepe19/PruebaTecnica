package app.prueba.pruebatecnica.ui.registro

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import app.prueba.pruebatecnica.ui.catalago.CatalogoActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistroActivity  : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegistroScreen(
                onRegistroExitoso = {
                    startActivity(Intent(this, CatalogoActivity::class.java))
                    finish()
                }
            )
        }
    }

}