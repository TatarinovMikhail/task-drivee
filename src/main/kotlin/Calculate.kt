import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.round
import kotlin.math.sin

const val nauticalMile = 60 // 1 градус широты или долготы равен 60 морским милям
const val mileRatio = 1.1515 // конвертация морских миль в обычные мили
const val radiansMultiplier = 180 // множитель для преобразования радианы в градусы
const val kmRatio = 1.609344

fun sortOrders(activeOrder: Route, orders: Array<Route>): List<Route> {
    val distances = arrayListOf<Route>()
      for (order in orders) {
          if (order.A.latitude == 0.0 || order.A.longitude == 0.0 ||
              order.B.latitude == 0.0 || order.B.longitude == 0.0) {
              throw IllegalArgumentException()
            }
        val distanceToPickup = calculateDistance(activeOrder.A, order.A)
        val distancePickupAndDropoff = calculateDistance(order.A, order.B)
        val distanceDropoffToEnd = calculateDistance(order.B, activeOrder.B)
        val distanceSum = distanceToPickup + distancePickupAndDropoff + distanceDropoffToEnd
        order.distance = distanceSum

        distances.add(order)
    }

    return distances.sortedBy { it.distance }
}

fun calculateDistance(routeA: Location, routeB: Location): Double {
    val delta = routeA.longitude - routeB.longitude
    val distance = nauticalMile * mileRatio * (radiansMultiplier / Math.PI) * acos(
        sin(routeA.latitude * (Math.PI / radiansMultiplier)) * sin(routeB.latitude * (Math.PI / radiansMultiplier)) +
                cos(routeA.latitude * (Math.PI / radiansMultiplier)) * cos(routeB.latitude * (Math.PI / radiansMultiplier)) * cos(delta * (Math.PI / radiansMultiplier))
    )
    distance * kmRatio
    return round(distance * 100) / 100
}