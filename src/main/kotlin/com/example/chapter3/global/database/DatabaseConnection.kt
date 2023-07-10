package com.example.chapter3.global.database

import org.ktorm.database.Database

object DatabaseConnection {
    val database: Database =
        Database.connect(
            url = "jdbc:mysql://localhost:3306/ktorm",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "root",
            password = "admin"
        )
}
