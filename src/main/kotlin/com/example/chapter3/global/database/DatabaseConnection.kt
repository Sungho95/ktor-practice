package com.example.chapter3.global.database


import com.example.chapter3.global.configuration.dbDriver
import com.example.chapter3.global.configuration.dbPassword
import com.example.chapter3.global.configuration.dbUrl
import com.example.chapter3.global.configuration.dbUsername
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.ktorm.database.Database
import org.ktorm.logging.ConsoleLogger
import org.ktorm.logging.LogLevel
import org.ktorm.support.mysql.MySqlDialect

object DatabaseConnection {

    val database = Database.connect(
        dataSource = HikariDataSource(
            HikariConfig().apply {
                jdbcUrl = dbUrl
                driverClassName = dbDriver
                username = dbUsername
                password = dbPassword
            }
        ),
        dialect = MySqlDialect(),
        logger = ConsoleLogger(threshold = LogLevel.INFO),
        alwaysQuoteIdentifiers = true,
        generateSqlInUpperCase = false
    )
}
