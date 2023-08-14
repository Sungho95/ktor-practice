package com.example.chapter3.domain.article.service

import com.example.chapter3.domain.article.dto.ArticlePatch
import com.example.chapter3.domain.article.dto.ArticlePost
import com.example.chapter3.domain.article.dto.ArticleResponse
import com.example.chapter3.domain.article.entity.Article
import com.example.chapter3.domain.article.repository.ArticleRepository
import com.example.chapter3.domain.member.repository.MemberRepository

class ArticleServiceImpl(

    private val articleRepository: ArticleRepository,
    private val memberRepository: MemberRepository

) : ArticleService {
    override fun createArticle(articlePost: ArticlePost): ArticleResponse {
        val findMember = memberRepository.findById(articlePost.memberId)
            ?: throw RuntimeException("회원을 찾을 수 없습니다.")

        val article = Article {
            title = articlePost.title
            content = articlePost.content
            category = articlePost.category
            member = findMember
        }

        val savedArticle = articleRepository.save(article)

        return ArticleResponse.from(savedArticle)
    }

    override fun getArticleList(): List<ArticleResponse> {
        TODO("Not yet implemented")
    }

    override fun getArticle(id: Long): ArticleResponse {
        TODO("Not yet implemented")
    }

    override fun updateArticle(articlePatch: ArticlePatch): ArticleResponse {
        TODO("Not yet implemented")
    }

    override fun deleteArticle(id: Long) {
        TODO("Not yet implemented")
    }


}