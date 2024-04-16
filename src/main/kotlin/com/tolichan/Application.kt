package com.tolichan

import com.tolichan.features.games.others.configureGameRouting
import com.tolichan.features.login.configureLoginRouting
import com.tolichan.features.register.configureRegisterRouting
import com.tolichan.plugins.configureRouting
import com.tolichan.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import org.jetbrains.exposed.sql.Database

fun main() {

    Database.connect(
        url = System.getenv("DATABASE_CONNECTION_STRING"),
        driver = "org.postgresql.Driver",
        user = System.getenv("POSTGRES_USER"),
        password = System.getenv("POSTGRES_PASSWORD")
    )

    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureLoginRouting()
    configureRegisterRouting()
    configureRouting()
    configureGameRouting()
}