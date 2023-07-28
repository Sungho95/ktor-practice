package com.example.chapter3.domain.member.repository

import com.example.chapter3.domain.member.entity.Member

interface MemberRepository {
    fun findAll(): List<Member>

    fun findById(id: Long): Member?

    fun save(member: Member): Member

    fun update(member: Member): Member

    fun delete(member: Member)
}
