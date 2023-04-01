package dev.argia.eguzkia

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EguzkiaApplication

fun main(args: Array<String>) {
    runApplication<EguzkiaApplication>(*args)
}
