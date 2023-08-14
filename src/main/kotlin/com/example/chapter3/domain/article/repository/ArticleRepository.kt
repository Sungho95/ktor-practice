package com.example.chapter3.domain.article.repository

import com.example.chapter3.domain.article.entity.Article

interface ArticleRepository {
    fun findAll(): List<Article>

    fun findById(id: Long): Article?

    fun save(article: Article): Article

    fun update(article: Article): Article

    fun delete(article: Article)
}