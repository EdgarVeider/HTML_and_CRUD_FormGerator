import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080) {
        install(DefaultHeaders)
        install(CallLogging)
        install(ContentNegotiation) {
            json()
        }
        routing {
            get("/") {
                call.respondText("Hello, world!", ContentType.Text.Plain)
            }
        }
    }.start(wait = true)
}