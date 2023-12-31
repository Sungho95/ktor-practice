package com.example.chapter3.domain.article.router

import com.example.chapter3.domain.article.dto.ArticlePost
import com.example.chapter3.domain.article.service.ArticleService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.articlePostRouter() {
    val articleService: ArticleService by inject()

    route("/api/v1/articles") {
        post {
            val body = call.receive<ArticlePost>()
            val response = articleService.createArticle(body)

            call.respond(status = HttpStatusCode.Created, message = response)
        }
    }
}