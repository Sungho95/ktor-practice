package com.example.chapter3.global.database

import com.example.chapter3.domain.member.entity.MemberTable
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf

object DatabaseConnection {
    val database: Database =
        Database.connect(
            url = "jdbc:mysql://localhost:3306/ktorm",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "root",
            password = "admin"
        )
}
