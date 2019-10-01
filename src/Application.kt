package com.brimanning.koinktorexample

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.commandLineEnvironment
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.koin.dsl.module
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject

fun main(args: Array<String>) {
    embeddedServer(Netty, commandLineEnvironment(args)).start(true)
}

fun Application.module() {
    install(Koin) {
        modules(module {
            single { SomeService() }
        })
    }

    // Lazy inject HelloService
    val service: SomeService by inject()

    // Routing section
    routing {
        get("/") {
            call.respondText(service.helloMessage())
        }
    }
}

