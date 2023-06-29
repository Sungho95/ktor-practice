package com.example.plugins

import com.example.customer.customerRouting
import com.example.order.getOrderRoute
import com.example.order.listOrdersRoute
import com.example.order.totalizeOrderRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*


fun Application.configureRouting() {
    routing {
        customerRouting()
        listOrdersRoute()
        getOrderRoute()
        totalizeOrderRoute()
    }
}
