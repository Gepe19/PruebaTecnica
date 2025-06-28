package app.prueba.pruebatecnica.data.respository

import app.prueba.pruebatecnica.data.local.UserDao
import app.prueba.pruebatecnica.data.local.UserEntity
import app.prueba.pruebatecnica.domain.repository.UserRepositoryInterface
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor (private val userDao: UserDao): UserRepositoryInterface {
    override suspend fun isUserLoggedIn(): Boolean {
        return userDao.getUser() != null
    }

    override suspend fun saveUser(user: UserEntity) {
        userDao.insertUser(user)

    }

}