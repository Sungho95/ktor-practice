package com.example.routes

import com.example.customer.customerStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.customerRouting() {
    route("/customer") {
        get {
            if (customerStorage.isNotEmpty()) {
                call.respond(customerStorage)
            } else {
                call.respondText(text = "No customers found", status = HttpStatusCode.OK)
            }
        }

        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                text = "Missing id",
                status = HttpStatusCode.BadRequest
            )

            val customer = customerStorage.find { it.id == id } ?: return@get call.respondText(
                text = ""
            )
        }
    }
}