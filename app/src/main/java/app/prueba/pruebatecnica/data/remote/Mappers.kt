package app.prueba.pruebatecnica.data.remote

import app.prueba.pruebatecnica.data.remote.planetaResponse.PlanetsResponse
import app.prueba.pruebatecnica.domain.model.Planet


fun PlanetsResponse.toPlanetList(): List<Planet> {
    return results.map { result ->
        Planet(
            name = result.name,
            climate = result.climate,
            terrain = result.terrain,
            population = result.population,
            diameter = result.diameter,
            gravity = result.gravity,
            orbital_period = result.orbital_period,
            rotation_period = result.rotation_period,
            surface_water = result.surface_water,
            residents = result.residents,
            films = result.films,
            created = result.created,
            edited = result.edited,
            url = result.url




        )
    }
}
