package com.example.plugins

import com.example.chapter1.customer.customerRouter
import com.example.chapter1.order.getOrderRouter
import com.example.chapter1.order.listOrdersRouter
import com.example.chapter1.order.totalizeOrderRouter
import com.example.chapter3.domain.article.router.articlesRouting
import com.example.chapter3.domain.member.router.memberRouter
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.lang.RuntimeException

fun Application.configureRouting() {
    routing {
        customerRouter()
        listOrdersRouter()
        getOrderRouter()
        totalizeOrderRouter()
        memberRouter()
    }
    articlesRouting()

    install(Routing) {
        install(ContentNegotiation) {
            // ...
        }

        // yes~
        get {
            // ...
        }

        // yes~
        post("hello") {
            // ...
        }

        // good
        get("/{id}") {
            val param = call.parameters["id"] ?: throw RuntimeException("message")
        }

        // ?!
        get(Regex(".+/hello")) {
            call.respondText("hello~")
        }

        // ??????????????
        get(Regex("""(?<id>\d+)/hello""")) {
            val id = call.parameters["id"]!!
            call.respondText(id)
        }

        // ??????????????
        get(Regex("hello/([a-z]+)")) {
            call.respondText("Hello")
        }
    }
}
