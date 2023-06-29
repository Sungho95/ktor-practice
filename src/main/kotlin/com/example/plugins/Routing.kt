package com.example.plugins

import com.example.customer.customerRouter
import com.example.order.getOrderRouter
import com.example.order.listOrdersRouter
import com.example.order.totalizeOrderRouter
import io.ktor.server.application.*
import io.ktor.server.routing.*


fun Application.configureRouting() {
    routing {
        customerRouter()
        listOrdersRouter()
        getOrderRouter()
        totalizeOrderRouter()
    }
}
