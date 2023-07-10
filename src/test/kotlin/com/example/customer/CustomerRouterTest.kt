//package com.example.customer
//
//import io.ktor.client.request.*
//import io.ktor.client.statement.*
//import io.ktor.content.*
//import io.ktor.http.*
//import io.ktor.server.testing.*
//import io.ktor.util.*
//import org.junit.Test
//import kotlin.test.assertEquals
//
//class CustomerRouterTest {
//
//    @Test
//    fun getCustomerListTest() = testApplication{
//        val response = client.get("/customer")
//        val expected = """
//            [
//                {
//                    "id":"100",
//                    "firstName":"Jane",
//                    "lastName":"Smith",
//                    "email":"jane.smith@company.com"
//                },
//                {
//                    "id":"200",
//                    "firstName":"John",
//                    "lastName":"Smith",
//                    "email":"john.smith@company.com"
//                },
//                {
//                    "id":"300",
//                    "firstName":"Mary",
//                    "lastName":"Smith",
//                    "email":"mary.smith@company.com"
//                }
//            ]""".trimIndent()
//
//        assertEquals(expected.replace("(\\s)".toRegex(), ""), response.bodyAsText())
//        assertEquals(HttpStatusCode.OK, response.status)
//    }
//
//    @Test
//    fun getCustomerTest() = testApplication {
//        val response = client.get("/customer/100")
//        val expected = """{"id":"100","firstName":"Jane","lastName":"Smith","email":"jane.smith@company.com"}"""
//
//        assertEquals(expected, response.bodyAsText())
//        assertEquals(HttpStatusCode.OK, response.status)
//    }
//
//    @Test
//    @OptIn(InternalAPI::class)
//    fun postCustomerTest() = testApplication {
//        val jsonString = """
//            {
//              "id" : "400",
//              "firstName" : "Sungho",
//              "lastName" : "Park",
//              "email" : "mary.smith@company.com"
//            }
//        """.trimIndent()
//
//        val response = client.post {
//            url("/customer")
//            contentType(ContentType.Application.Json)
//            body = TextContent(jsonString, ContentType.Application.Json)
//        }
//
//        assertEquals(HttpStatusCode.Created, response.status)
//    }
//
//
//    @Test
//    fun deleteCustomerTest() = testApplication {
//        val response = client.delete("/customer/100")
//
//        assertEquals(HttpStatusCode.Accepted, response.status)
//    }
//}