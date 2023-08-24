fun main() {

    val activeOrder = createFixture(
        1,
        "Красноярова 22",
        "203 мкр, корпус 7",
        A = Location(62.014980, 129.714482,),
        B = Location(62.031844, 129.759402,),
        0.0)

    val orders = arrayOf(
        createFixture(1, "КФЕН" ,"КГФ",
            A = Location(62.016178, 129.704019),
            B = Location(62.032922, 129.750487),0.0),
        createFixture(2, "к/т Лена", "к/т Центральный",
            A = Location(62.020053, 129.720391),
            B =  Location(62.030689, 129.739031),0.0),
        createFixture(3, "к/т Лена","SMART 203",
            A = Location(62.020053, 129.720391),
            B = Location(62.030108, 129.762206),0.0)
    )

    val sort = sortOrders(activeOrder, orders)
    println("Наиболее подходящие заказы по пути маршрута:")

    for (order in sort) {
        println("Заказ: ID ${order.id}")
        println("От: ${order.from}")
        println("До: ${order.to}")
        println("Расстояние: ${order.distance}")
        println("Подача: ${order.A}")
        println("Высадка: ${order.B}")
        println()
    }
}

fun createFixture(id: Int, from: String, to: String, A: Location, B: Location, distance: Double): Route {
    return Route(id,from,to,A,B,distance)
}
