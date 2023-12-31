package com.example.chapter3.domain.article.entity

import com.example.chapter3.domain.member.entity.Member
import com.example.chapter3.domain.member.entity.MemberTable
import org.ktorm.database.Database
import org.ktorm.entity.Entity
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.long
import org.ktorm.schema.varchar

object ArticleTable : Table<Article>("article") {
    val id = long("id").primaryKey().bindTo { it.id }
    val title = varchar("title").bindTo { it.title }
    val content = varchar("content").bindTo { it.content }
    val category = varchar("category").bindTo { it.category }
    val memberId = long("member_id").references(MemberTable) { it.member }
}

interface Article : Entity<Article> {
    companion object : Entity.Factory<Article>()

    val id: Long
    var title: String
    var content: String
    var category: String
    var member: Member
}

val Database.articles get() = this.sequenceOf(ArticleTable)