package com.example.chapter3.domain.article.dto

import com.example.chapter3.domain.article.entity.Article

data class ArticleResponse(
    val id: Long,
    val memberId: Long,
    val title: String,
    val content: String,
    val category: String
) {
    companion object {
        fun from(article: Article): ArticleResponse {
            return ArticleResponse(
                id = article.id,
                memberId = article.member.id,
                title = article.title,
                content = article.content,
                category = article.category
            )
        }
    }
}