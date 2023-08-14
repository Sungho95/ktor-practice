package com.example.chapter3.domain.article.dto

data class ArticlePost(
    val title: String,
    val content: String,
    val category: String,
    val memberId: Long
)

data class ArticlePatch(
    val id: Long,
    val title: String?,
    val content: String?,
    val category: String?,
    val memberId: Long
)