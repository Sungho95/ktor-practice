package com.example.chapter1.customer

import kotlinx.serialization.Serializable

@Serializable
data class Customer(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String
) {
    fun hello(firstName: String): String {
        return "hello $firstName"
    }
}

val customerStorage = mutableListOf<Customer>(
    Customer(id = "100", firstName = "Jane", lastName = "Smith", email = "jane.smith@company.com"),
    Customer(id = "200", firstName = "John", lastName = "Smith", email = "john.smith@company.com"),
    Customer(id = "300", firstName = "Mary", lastName = "Smith", email = "mary.smith@company.com")
)