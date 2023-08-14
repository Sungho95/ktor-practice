package com.example.chapter3.domain.article.service

import com.example.chapter3.domain.article.dto.ArticlePatch
import com.example.chapter3.domain.article.dto.ArticlePost
import com.example.chapter3.domain.article.dto.ArticleResponse

interface ArticleService {
    fun createArticle(articlePost: ArticlePost): ArticleResponse

    fun getArticleList(): List<ArticleResponse>

    fun getArticle(id: Long): ArticleResponse

    fun updateArticle(articlePatch: ArticlePatch): ArticleResponse

    fun deleteArticle(id: Long)
}