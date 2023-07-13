package com.example.chapter3.domain.member.service

import com.example.chapter3.domain.member.dto.request.MemberPost
import com.example.chapter3.domain.member.dto.response.MemberResponse
import com.example.chapter3.domain.member.entity.Member
import com.example.chapter3.domain.member.repository.MemberRepository

class MemberServiceImpl(

    private val memberRepository: MemberRepository

) : MemberService {

    override fun createMember(memberPostDto: MemberPost) {
        val member = Member {
            name = memberPostDto.name
            age = memberPostDto.age
        }

        memberRepository.save(member)
    }

    override fun getMemberList(): List<MemberResponse> {
        val findMemberList = memberRepository.findAll()

        if (findMemberList.isEmpty()) {
            throw RuntimeException("비어있음")
        }

        return findMemberList.map { member ->
            MemberResponse(member.id, member.name, member.age)
        }
    }

    override fun getMember(id: Long): MemberResponse {
        val member = memberRepository.findById(id) ?: throw RuntimeException("회원을 찾을 수 없습니다.")
        return MemberResponse(member.id, member.name, member.age)
    }

    override fun deleteMember(id: Long) {
        val member = memberRepository.findById(id) ?: throw RuntimeException("회원을 찾을 수 없습니다.")
        return memberRepository.delete(member)
    }
}
