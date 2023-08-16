package com.example.chapter3.domain.article.router

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.articleConfigureRouting() {
    routing {
        articlePostRouter()
        articleGetRouter()
        articlePatchRouter()
        articleDeleteRouter()
    }
}