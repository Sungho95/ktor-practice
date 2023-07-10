package com.example.plugins

import com.example.chapter3.domain.member.repository.MemberRepository
import com.example.chapter3.domain.member.repository.MemberRepositoryImpl
import com.example.chapter3.domain.member.service.MemberService
import com.example.chapter3.domain.member.service.MemberServiceImpl
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

fun Application.configureKoin() {
    install(Koin) {
        modules(appModule)
    }
}

val appModule = module {
    single<MemberRepository> { MemberRepositoryImpl() }
    single<MemberService> { MemberServiceImpl(get()) }
}