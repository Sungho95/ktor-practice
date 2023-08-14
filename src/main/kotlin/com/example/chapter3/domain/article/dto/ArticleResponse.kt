package com.example.chapter3.domain.article.dto

import com.example.chapter3.domain.article.entity.Article

data class ArticleResponse(
    val id: Long,
    val title: String,
    val content: String,
    val category: String,
    val memberId: Long,
    val memberName: String,
    val memberAge: Int

) {
    companion object {
        fun from(article: Article): ArticleResponse {
            return ArticleResponse(
                id = article.id,
                title = article.title,
                content = article.content,
                category = article.category,
                memberId = article.member.id,
                memberName = article.member.name,
                memberAge = article.member.age
            )
        }
    }
}