package app.prueba.pruebatecnica.domain.repository

import app.prueba.pruebatecnica.domain.model.Planet

interface PlanetRepository {
    suspend fun getPlanets(): Result<List<Planet>>
}