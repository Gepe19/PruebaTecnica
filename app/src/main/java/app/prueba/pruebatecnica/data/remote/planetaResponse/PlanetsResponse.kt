package app.prueba.pruebatecnica.data.remote.planetaResponse

data class PlanetsResponse (
   var  count: Int = 0,
   var next : String? = null,
   var previous : String? = null,
   var results : List<PlanetResponse> = emptyList()


)