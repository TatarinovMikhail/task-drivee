import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test {

    @Test
    fun SortingOrders(){
        val activeOrder = createFixture(
            1,
            "Красноярова 22",
            "203 мкр, корпус 7",
            A = Location(62.014980, 129.714482,),
            B = Location(62.031844, 129.759402,),
            0.0)
        val orders = arrayOf(
            createFixture(
                1,
                "КФЕН" ,
                "КГФ",
                A = Location(62.016178, 129.704019),
                B = Location(62.032922, 129.750487),
                0.0),
            createFixture(
                2,
                "к/т Лена",
                "к/т Центральный",
                A = Location(62.020053, 129.720391),
                B =  Location(62.030689, 129.739031),
                0.0),
            createFixture(
                3,
                "к/т Лена",
                "SMART 203",
                A = Location(62.020053, 129.720391),
                B = Location(62.030108, 129.762206),
                0.0)
        )

        val actual = sortOrders(activeOrder, orders)

        val expectedOrders = arrayListOf(
            orders[1],
            orders[2],
            orders[0])
        Assertions.assertEquals(expectedOrders,actual)
    }

    @Test
    fun SingleOrder(){
        val activeOrder = createFixture(
            1,
            "Красноярова 22",
            "203 мкр, корпус 7",
            A = Location(62.014980, 129.714482,),
            B = Location(62.031844, 129.759402,),
            0.0)
        val order = arrayOf(
            createFixture(
                1,
                "КФЕН" ,
                "КГФ",
                A = Location(62.016178, 129.704019),
                B = Location(62.032922, 129.750487),
                0.0))

        val actual = sortOrders(activeOrder, order)

        val expectedOrders = arrayListOf(
            order[0])
        Assertions.assertEquals(expectedOrders,actual)
    }

    @Test
    fun InvalidTest() {
        val activeOrder = createFixture(
            1,
            "Красноярова 22",
            "203 мкр, корпус 7",
            A = Location(62.014980, 129.714482,),
            B = Location(62.031844, 129.759402,),
            0.0)

        val order = arrayOf(
            createFixture(
                2,
                "Столичный рынок",
                "Манньыаттаах",
                A = Location(0.0, 0.0),
                B = Location(0.0, 0.0),
                0.0)
        )
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            sortOrders(activeOrder, order )
        }
    }
}

