package me.ccampo.knbody.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KnbodyWebApplication

fun main(args: Array<String>) {
    runApplication<KnbodyWebApplication>(*args)
}
