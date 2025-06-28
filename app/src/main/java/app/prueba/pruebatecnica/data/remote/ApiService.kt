package app.prueba.pruebatecnica.data.remote

import app.prueba.pruebatecnica.data.remote.planetaResponse.PlanetsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("planets/")
    suspend fun getPlanets(): PlanetsResponse
}