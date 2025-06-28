package app.prueba.pruebatecnica.domain.repository

import app.prueba.pruebatecnica.data.local.UserEntity

interface UserRepositoryInterface {
    suspend fun isUserLoggedIn(): Boolean
    suspend fun saveUser(user: UserEntity)

}