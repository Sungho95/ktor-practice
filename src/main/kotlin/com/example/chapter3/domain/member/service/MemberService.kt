package com.example.chapter3.domain.member.service

import com.example.chapter3.domain.member.dto.MemberPatch
import com.example.chapter3.domain.member.dto.MemberPost
import com.example.chapter3.domain.member.dto.MemberResponse

interface MemberService {
    fun createMember(memberPost: MemberPost): MemberResponse

    fun getMemberList(): List<MemberResponse>

    fun getMember(id: Long): MemberResponse

    fun updateMember(memberPatch: MemberPatch): MemberResponse

    fun deleteMember(id: Long)
}
