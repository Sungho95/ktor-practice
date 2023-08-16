package com.example.plugins

import com.example.chapter3.domain.article.repository.ArticleRepository
import com.example.chapter3.domain.article.repository.ArticleRepositoryImpl
import com.example.chapter3.domain.article.service.ArticleService
import com.example.chapter3.domain.article.service.ArticleServiceImpl
import com.example.chapter3.domain.member.repository.MemberRepository
import com.example.chapter3.domain.member.repository.MemberRepositoryImpl
import com.example.chapter3.domain.member.service.MemberService
import com.example.chapter3.domain.member.service.MemberServiceImpl
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger()
        modules(appModule)
    }
}

val appModule = module {
    single<MemberRepository> { MemberRepositoryImpl() }
    single<MemberService> { MemberServiceImpl(get()) }
    single<ArticleRepository> { ArticleRepositoryImpl() }
    single<ArticleService> { ArticleServiceImpl(get(), get()) }
}
