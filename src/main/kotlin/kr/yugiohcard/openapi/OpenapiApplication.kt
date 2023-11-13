package kr.yugiohcard.openapi

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@OpenAPIDefinition(
    servers = [Server(url = "/", description = "Default Server url")]
)
@SpringBootApplication
class OpenapiApplication

fun main(args: Array<String>) {
    runApplication<OpenapiApplication>(*args)
}

