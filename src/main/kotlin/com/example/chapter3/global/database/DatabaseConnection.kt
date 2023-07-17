package com.example.chapter3.global.database


import com.example.chapter3.global.configuration.*
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
                jdbcUrl = yamlConfig.ktorm.database.url
                driverClassName = yamlConfig.ktorm.database.driver
                username = yamlConfig.ktorm.database.username
                password = yamlConfig.ktorm.database.password
            }
        ),
        dialect = MySqlDialect(),
        logger = ConsoleLogger(threshold = LogLevel.INFO),
        alwaysQuoteIdentifiers = true,
        generateSqlInUpperCase = false
    )
}
