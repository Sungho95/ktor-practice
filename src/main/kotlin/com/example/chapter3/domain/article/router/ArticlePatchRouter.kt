package com.example.chapter3.domain.article.router

import com.example.chapter3.domain.article.dto.ArticlePatch
import com.example.chapter3.domain.article.service.ArticleService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.articlePatchRouter() {
    val articleService: ArticleService by inject()

    route("/api/v1/articles") {
        patch {
            val body = call.receive<ArticlePatch>()
            val response = articleService.updateArticle(body)

            call.respond(status = HttpStatusCode.OK, message = response)
        }
    }
}