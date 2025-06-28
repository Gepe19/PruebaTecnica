package app.prueba.pruebatecnica.ui.registro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.prueba.pruebatecnica.data.local.UserEntity
import app.prueba.pruebatecnica.domain.model.User
import app.prueba.pruebatecnica.domain.repository.UserRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistroViewModel  @Inject constructor(private val userRepository: UserRepositoryInterface) : ViewModel() {




    private val _userForm = MutableStateFlow(User("", "", "", "", ""))
    val userForm: StateFlow<User> = _userForm


    fun onNameChange(value: String) {

        _userForm.value = _userForm.value.copy( name = value)
    }
    fun onLastNameChange(newLastName: String) {
        _userForm.value = _userForm.value.copy( lastName = newLastName)
    }
    fun onMotherLastNameChange(newMotherLastName: String) {
        _userForm.value = _userForm.value.copy( motherLastName = newMotherLastName)
    }
    fun onBirthDateChange(newBirthDate: String) {
        _userForm.value = _userForm.value.copy( birthDate = newBirthDate)
    }
    fun onCountryChange(newCountry: String) {
        _userForm.value = _userForm.value.copy( country = newCountry)

    }

    fun validarCampos(): Boolean {
        return  _userForm.value.name.isNotBlank() &&
                _userForm.value.lastName.isNotBlank() &&
                _userForm.value.motherLastName.isNotBlank() &&
                _userForm.value.birthDate.isNotBlank() &&
                _userForm.value.country.isNotBlank()
    }

    fun registrarUsuario(onSuccess: () -> Unit) {
        viewModelScope.launch {
            userRepository.saveUser(
                UserEntity(
                    name = _userForm.value.name,
                    lastName = _userForm.value.lastName,
                    motherLastName = _userForm.value.motherLastName,
                    birthDate = _userForm.value.birthDate,
                    country = _userForm.value.country
                )
            )
            onSuccess()
        }
    }
}