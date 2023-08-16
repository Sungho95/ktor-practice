package com.example.chapter3.domain.article.router

import com.example.chapter3.domain.article.service.ArticleService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.articleDeleteRouter() {
    val articleService: ArticleService by inject()

    route("/api/v1/articles") {
        delete("{id}") {
            val id = call.parameters["id"] ?: return@delete call.respondText(
                text = "게시글을 찾을 수 없습니다..",
                status = HttpStatusCode.BadRequest
            )

            id.toLong().let {
                articleService.deleteArticle(it)
            }

            call.respondText(
                text = "$id 게시글 삭제 성공",
                status = HttpStatusCode.NoContent
            )
        }
    }
}