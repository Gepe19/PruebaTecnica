package app.prueba.pruebatecnica.ui.catalago

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.prueba.pruebatecnica.domain.model.Planet
import app.prueba.pruebatecnica.domain.repository.PlanetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogoViewModel @Inject constructor(
    private val planetRepository: PlanetRepository
) : ViewModel() {
    private val _planets = MutableLiveData<List<Planet>?>()
    val planets: MutableLiveData<List<Planet>?> = _planets

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage


    fun getPlanets() {
        viewModelScope.launch {
            val planets1: Result<List<Planet>> = planetRepository.getPlanets()
            if (planets1.isSuccess) {
                _planets.value = planets1.getOrNull()
            } else {
               _errorMessage.value = "Error: ${planets1.exceptionOrNull()?.message}"
            }

        }
    }
}