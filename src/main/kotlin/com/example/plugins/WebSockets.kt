package com.example.plugins

import com.example.chapter2.websocket.Connection
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import java.time.Duration
import java.util.*
import kotlin.collections.LinkedHashSet

fun Application.configureSockets() {
    install(WebSockets) {
        pingPeriod = Duration.ofSeconds(15)
        timeout = Duration.ofSeconds(15)
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }
    routing {
        // Connection 객체를 담기위한 LinkedHashSet
        val connections = Collections.synchronizedSet<Connection?>(LinkedHashSet())

        webSocket("/chat") {
            // 사용자 추가
            val thisConnection = Connection(this)
            connections += thisConnection

            try {
                send("연결 완료! ${connections.count()}명의 사용자가 존재합니다.")

                for (frame in incoming) {
                    frame as? Frame.Text ?: continue
                    val receivedText = frame.readText()
                    val textWithUsername = "[${thisConnection.name}]: $receivedText"

                    // 연결된 사용자에게 메세지 보내기
                    connections.forEach {
                        it.session.send(textWithUsername)
                    }
                }
            } catch (e: Exception) {
                println(e.localizedMessage)
            } finally {
                connections.forEach {
                    it.session.send("${thisConnection.name}님이 나가셨습니다.")
                }
                connections -= thisConnection
            }
        }
    }
}