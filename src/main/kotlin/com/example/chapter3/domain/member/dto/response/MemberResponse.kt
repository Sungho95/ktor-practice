package com.example.chapter3.domain.member.dto.response

import com.example.chapter3.domain.member.entity.Member

data class MemberResponse(
    val id: Long,
    val name: String,
    val age: Int
) {

    companion object {
        fun of(member: Member) =
            MemberResponse(
                id = member.id,
                name = member.name,
                age = member.age
            )
    }
}