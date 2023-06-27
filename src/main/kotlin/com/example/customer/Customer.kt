package com.example.customer

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

val customerStorage = mutableListOf<Customer>()