package com.example.chapter3.domain.member.dto

data class MemberPost(
    val name: String,
    val age: Int
)

data class MemberPatch(
    val id: Long,
    val name: String,
    val age: Int
)
