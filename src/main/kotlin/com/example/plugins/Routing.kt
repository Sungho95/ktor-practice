package com.example.plugins

import com.example.chapter1.customer.customerRouter
import com.example.chapter1.order.getOrderRouter
import com.example.chapter1.order.listOrdersRouter
import com.example.chapter1.order.totalizeOrderRouter
import com.example.chapter3.domain.member.router.memberRouter
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        customerRouter()
        listOrdersRouter()
        getOrderRouter()
        totalizeOrderRouter()
        memberRouter()
    }
}
