package com.example.chapter3.domain.article.router

import com.example.chapter3.domain.article.service.ArticleService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.articleGetRouter() {
    val articleService: ArticleService by inject()

    route("/api/v1/articles") {
        get {
            val response = articleService.getArticleList()

            call.respond(status = HttpStatusCode.OK, message = response)
        }

        get("{id}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                text = "게시글을 찾을 수 없습니다.",
                status = HttpStatusCode.BadRequest
            )

            val response = id.toLong().let {
                articleService.getArticle(it)
            }

            call.respond(status = HttpStatusCode.OK, message = response)
        }
    }
}