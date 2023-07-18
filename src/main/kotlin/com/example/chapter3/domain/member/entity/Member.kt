package com.example.chapter3.domain.member.entity

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.long
import org.ktorm.schema.varchar

object MemberTable : Table<Member>("member") {
    val id = long("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
    val age = int("age").bindTo { it.age }
}

interface Member : Entity<Member> {
    companion object : Entity.Factory<Member>()

    val id: Long
    var name: String
    var age: Int
}
