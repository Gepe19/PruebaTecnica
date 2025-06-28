package app.prueba.pruebatecnica.data.remote.planetaResponse

data class PlanetResponse (
    var name : String ?= null,
    var rotation_period : String ?= null,
    var  orbital_period : String ?= null,
    var diameter : String ?= null,
    var climate : String ?= null,
    var gravity : String ?= null,
    var terrain : String ?= null,
    var surface_water : String ?= null,
    var population : String ?= null,
    var residents : List<String> = emptyList(),
    var films : List<String> = emptyList(),
    var created : String ?= null,
    var edited : String ?= null,
    var url : String ?= null

)