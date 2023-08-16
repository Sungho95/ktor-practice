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
            throw RuntimeException("회원 목록을 찾을 수 없습니다.")
        }

        return findMemberList.map { MemberResponse.from(it) }
    }

    override fun getMember(id: Long): MemberResponse {
        val findMember = memberRepository.findById(id) ?: throw RuntimeException("회원을 찾을 수 없습니다.")

        return MemberResponse.from(findMember)
    }

    override fun updateMember(memberPatch: MemberPatch): MemberResponse {
        val findMember = memberRepository.findById(memberPatch.id) ?: throw RuntimeException("회원을 찾을 수 없습니다.")
        findMember.name = memberPatch.name
        findMember.age = memberPatch.age
        val updatedMember = memberRepository.update(findMember)

        return MemberResponse.from(updatedMember)
    }

    override fun deleteMember(id: Long) {
        val findMember = memberRepository.findById(id) ?: throw RuntimeException("회원을 찾을 수 없습니다.")

        memberRepository.delete(findMember)
    }
}
