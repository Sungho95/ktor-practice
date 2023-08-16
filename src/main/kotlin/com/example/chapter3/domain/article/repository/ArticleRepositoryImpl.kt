package com.example.chapter3.domain.article.repository

import com.example.chapter3.domain.article.entity.Article
import com.example.chapter3.domain.article.entity.articles
import com.example.chapter3.global.database.DatabaseConnection
import org.ktorm.dsl.eq
import org.ktorm.entity.*

class ArticleRepositoryImpl : ArticleRepository {

    private val database = DatabaseConnection.database

    override fun findAll(): List<Article> {

        return database.articles.toList()
    }

    override fun findById(id: Long): Article? {

        return database.articles
            .find { it.id eq id }
    }

    override fun save(article: Article): Article {
        database.articles.add(article)

        return database.articles.last()
    }

    override fun update(article: Article): Article {
        database.articles.update(article)

        return database.articles.find { it.id eq article.id }!!
    }

    override fun delete(article: Article) {
        database.articles.removeIf { it.id eq article.id }
    }
}