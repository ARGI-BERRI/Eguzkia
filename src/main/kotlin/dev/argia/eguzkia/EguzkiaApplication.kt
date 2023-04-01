package dev.argia.eguzkia

import dev.argia.eguzkia.storage.StorageService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class EguzkiaApplication {
    @Bean
    fun init(storageService: StorageService) = CommandLineRunner {
        storageService.init()
    }
}

fun main(args: Array<String>) {
    runApplication<EguzkiaApplication>(*args)
}
