package app.prueba.pruebatecnica.data.respository

import app.prueba.pruebatecnica.data.remote.ApiService
import app.prueba.pruebatecnica.data.remote.toPlanetList
import app.prueba.pruebatecnica.domain.model.Planet
import app.prueba.pruebatecnica.domain.repository.PlanetRepository
import javax.inject.Inject

class PlanetRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : PlanetRepository {
    override suspend fun getPlanets(): Result<List<Planet>> {
        return try {
            val response = apiService.getPlanets()
            Result.success(response.toPlanetList())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

