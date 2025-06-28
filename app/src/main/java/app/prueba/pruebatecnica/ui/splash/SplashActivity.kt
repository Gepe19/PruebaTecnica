package app.prueba.pruebatecnica.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import app.prueba.pruebatecnica.ui.catalago.CatalogoActivity
import app.prueba.pruebatecnica.ui.registro.RegistroActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity  : AppCompatActivity(){

    private val viewModel: SplashViewModel by viewModels()
    private var isReady = false

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { !isReady }
        super.onCreate(savedInstanceState)
        viewModel.userLogin.observe(this) { exists ->
            val intent = if (exists) {
                Intent(this, CatalogoActivity::class.java)
            } else {
                Intent(this, RegistroActivity::class.java)
            }
            isReady = true
            startActivity(intent)
            finish()
        }

        viewModel.checkUser()
    }

}