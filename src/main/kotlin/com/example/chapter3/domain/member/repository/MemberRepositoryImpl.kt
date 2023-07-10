package com.example.chapter3.domain.member.repository

import com.example.chapter3.domain.member.entity.Member
import com.example.chapter3.domain.member.entity.MemberTable
import com.example.chapter3.global.database.DatabaseConnection
import org.ktorm.dsl.*
import org.ktorm.entity.find
import org.ktorm.entity.removeIf
import org.ktorm.entity.sequenceOf

class MemberRepositoryImpl : MemberRepository {
    private val database = DatabaseConnection.database
    override fun findAll(): List<Member> {

        return database.from(MemberTable)
            .select()
            .orderBy(MemberTable.id.asc())
            .map { row ->
                MemberTable.createEntity(row)
            }
            .toList()
    }

    override fun findById(id: Long): Member? {
        return database.sequenceOf(MemberTable)
            .find { it.id eq id }
    }

    override fun save(member: Member) {
        database.insert(MemberTable) {
            set(it.id, member.id)
            set(it.name, member.name)
            set(it.age, member.age)
        }
    }

    override fun update(member: Member) {
        database.update(MemberTable) {
            set(it.name, member.name)
            set(it.age, member.age)
            where {
                it.id eq member.id
            }
        }
    }

    override fun delete(member: Member) {
        database.sequenceOf(MemberTable)
            .removeIf { it.id eq member.id }
    }
}
