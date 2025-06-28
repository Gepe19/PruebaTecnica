package app.prueba.pruebatecnica.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.prueba.pruebatecnica.domain.repository.UserRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val userRepository: UserRepositoryInterface
) : ViewModel() {

    private val _userLogin = MutableLiveData<Boolean>()
    val userLogin: LiveData<Boolean> = _userLogin

    fun checkUser() {
        viewModelScope.launch {
            val exists = userRepository.isUserLoggedIn()
            _userLogin.postValue(exists)
        }
    }
}