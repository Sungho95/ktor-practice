package com.example.chapter3.global.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.io.File

data class YamlConfig(
    val ktor: KtorConfig,
    val ktorm: KtormConfig
)

data class KtorConfig(
    val application: ApplicationConfig,
    val deployment: DeploymentConfig
)

data class ApplicationConfig(
    val modules: List<String>
)

data class DeploymentConfig(
    val port: Int
)


data class KtormConfig(
    val database: DatabaseConfig
)

data class DatabaseConfig(
    val url: String,
    val driver: String,
    val username: String,
    val password: String
)

fun loadYamlConfig(): YamlConfig {
    val objectMapper = ObjectMapper(YAMLFactory()).registerModule(KotlinModule())
    val yamlFile = File("src/main/resources/application.yaml")
    return objectMapper.readValue(yamlFile, YamlConfig::class.java)
}

val yamlConfig = loadYamlConfig()
val dbJdbcUrl = yamlConfig.ktorm.database.url
val dbDriverClassName = yamlConfig.ktorm.database.driver
val dbUsername = yamlConfig.ktorm.database.username
val dbPassword = yamlConfig.ktorm.database.password
