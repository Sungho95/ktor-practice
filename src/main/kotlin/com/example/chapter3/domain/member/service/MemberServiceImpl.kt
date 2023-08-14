package com.example.chapter3.domain.member.service

import com.example.chapter3.domain.member.dto.MemberPatch
import com.example.chapter3.domain.member.dto.MemberPost
import com.example.chapter3.domain.member.dto.MemberResponse
import com.example.chapter3.domain.member.entity.Member
import com.example.chapter3.domain.member.repository.MemberRepository

class MemberServiceImpl(

    private val memberRepository: MemberRepository

) : MemberService {

    override fun createMember(memberPost: MemberPost): MemberResponse {
        val member = Member {
            name = memberPost.name
            age = memberPost.age
        }

        val savedMember = memberRepository.save(member)

        return MemberResponse.from(savedMember)
    }

    override fun getMemberList(): List<MemberResponse> {
        val findMemberList = memberRepository.findAll()

        if (findMemberList.isEmpty()) {
            throw RuntimeException("비어있음")
        }

        return findMemberList.map { member ->
            MemberResponse.from(member)
        }
    }

    override fun getMember(id: Long): MemberResponse {
        val member = memberRepository.findById(id) ?: throw RuntimeException("회원을 찾을 수 없습니다.")
        return MemberResponse.from(member)
    }

    override fun updateMember(memberPatch: MemberPatch): MemberResponse {
        val member = memberRepository.findById(memberPatch.id) ?: throw RuntimeException("회원을 찾을 수 없습니다.")
        member.name = memberPatch.name
        member.age = memberPatch.age
        val updatedMember = memberRepository.update(member)

        return MemberResponse.from(updatedMember)
    }

    override fun deleteMember(id: Long) {
        val member = memberRepository.findById(id) ?: throw RuntimeException("회원을 찾을 수 없습니다.")
        memberRepository.delete(member)
    }
}
