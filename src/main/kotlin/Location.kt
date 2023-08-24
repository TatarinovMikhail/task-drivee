data class Location(
    val longitude: Double,
    val latitude: Double
)

data class Route(
    val id: Int,
    val from: String,
    val to: String,
    val A: Location,
    val B: Location,
    var distance: Double
)

