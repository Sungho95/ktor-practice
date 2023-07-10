package com.example.chapter3.domain.member.router

import com.example.chapter3.domain.member.dto.request.MemberPost
import com.example.chapter3.domain.member.service.MemberService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.memberRouter() {
    val memberService: MemberService by inject()

    route("/api/v1/members") {
        get {
            val response = memberService.getMemberList()
            call.respond(status = HttpStatusCode.OK, message = response)
        }

        post {
            val body = call.receive<MemberPost>()
            memberService.createMember(body)

            val createdMember = memberService.getMemberList().last()
            call.respond(HttpStatusCode.Created, createdMember)
        }
    }
}
