package com.example.chapter3.domain.member.router

import com.example.chapter3.domain.member.dto.request.MemberPatch
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
        post {
            val body = call.receive<MemberPost>()
            val response = memberService.createMember(body)

            call.respond(HttpStatusCode.Created, response)
        }

        get {
            val response = memberService.getMemberList()
            call.respond(status = HttpStatusCode.OK, message = response)
        }

        get("{id}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                text = "회원을 식별할 수 없습니다.",
                status = HttpStatusCode.BadRequest
            )
            val response = id.toLong().let {
                memberService.getMember(it)
            }

            call.respond(status = HttpStatusCode.OK, message = response)
        }

        patch() {
            val body = call.receive<MemberPatch>()
            val response = memberService.updateMember(body)

            call.respond(status = HttpStatusCode.OK, message = response)
        }

        delete("{id}") {
            val id = call.parameters["id"] ?: return@delete call.respondText(
                text = "회원을 식별할 수 없습니다.",
                status = HttpStatusCode.BadRequest
            )
            id.toLong().let {
                memberService.deleteMember(it)
            }
            call.respondText(
                text = "$id 회원 탈퇴 성공",
                status = HttpStatusCode.OK
            )
        }
    }
}
