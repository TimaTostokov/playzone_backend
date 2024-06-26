package com.tolichan.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello, World")
        }

        get("/test") {
            call.respondText("Test Hello World")
        }
    }
}