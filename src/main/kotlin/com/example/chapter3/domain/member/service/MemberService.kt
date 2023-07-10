package com.example.chapter3.domain.member.service

import com.example.chapter3.domain.member.dto.request.MemberPost
import com.example.chapter3.domain.member.dto.response.MemberResponse

interface MemberService {

    fun createMember(memberPostDto: MemberPost)

    fun getMemberList(): List<MemberResponse>

    fun getMember(id: Long): MemberResponse
}
