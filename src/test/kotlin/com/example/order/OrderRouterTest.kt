//package com.example.order
//
//import io.ktor.client.request.*
//import io.ktor.client.statement.*
//import io.ktor.http.*
//import io.ktor.server.testing.*
//import org.junit.Assert.*
//import org.junit.Test
//
//class OrderRouterTest {
//
//    @Test
//    fun getOrderTest() = testApplication {
//        val response = client.get("/order/2023-01-01-01")
//        val expected = """{"number":"2023-01-01-01","contents":[{"item":"Ham Sandwich","amount":2,"price":5.5},{"item":"Water","amount":1,"price":1.5},{"item":"Beer","amount":3,"price":2.5},{"item":"Cheesecake","amount":1,"price":3.75}]}"""
//
//        assertEquals(expected, response.bodyAsText())
//        assertEquals(HttpStatusCode.OK, response.status)
//    }
//
//    @Test
//    fun getOrderListTest() = testApplication {
//        val response = client.get("/order")
//        val expected = """[{"number":"2023-01-01-01","contents":[{"item":"Ham Sandwich","amount":2,"price":5.5},{"item":"Water","amount":1,"price":1.5},{"item":"Beer","amount":3,"price":2.5},{"item":"Cheesecake","amount":1,"price":3.75}]},{"number":"2023-07-01-01","contents":[{"item":"Cheeseburger","amount":1,"price":8.5},{"item":"Water","amount":2,"price":1.5},{"item":"Coke","amount":2,"price":1.76},{"item":"Ice Cream","amount":1,"price":2.35}]}]"""
//
//        assertEquals(expected, response.bodyAsText())
//        assertEquals(HttpStatusCode.OK, response.status)
//    }
//
//    @Test
//    fun getTotalizeOrderTest() = testApplication {
//        val response = client.get("/order/2023-01-01-01/total")
//        val expected = "23.75"
//
//        assertEquals(expected, response.bodyAsText())
//        assertEquals(HttpStatusCode.OK, response.status)
//    }
//}