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
        val findArticleList = articleRepository.findAll()

        if (findArticleList.isEmpty()) {
            throw RuntimeException("게시글 목록을 찾을 수 없습니다.")
        }

        return findArticleList.map { ArticleResponse.from(it) }
    }

    override fun getArticle(id: Long): ArticleResponse {
        val findArticle = articleRepository.findById(id) ?: throw RuntimeException("게시글을 찾을 수 없습니다.")

        return ArticleResponse.from(findArticle)
    }

    override fun updateArticle(articlePatch: ArticlePatch): ArticleResponse {
        val findArticle = articleRepository.findById(articlePatch.id)
            ?: throw RuntimeException("게시글을 찾을 수 없습니다.")

        if (articlePatch.memberId != findArticle.member.id) {
            throw RuntimeException("수정할 수 없습니다.")
        }

        findArticle.title = articlePatch.title
        findArticle.content = articlePatch.content
        findArticle.category = articlePatch.category
        val updateArticle = articleRepository.update(findArticle)

        return ArticleResponse.from(updateArticle)
    }

    override fun deleteArticle(id: Long) {
        val findArticle = articleRepository.findById(id) ?: throw RuntimeException("게시글을 찾을 수 없습니다.")

        articleRepository.delete(findArticle)
    }
}