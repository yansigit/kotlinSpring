package com.hwc.kotlinspring

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean

@SpringBootApplication
class KotlinSpringApplication {
    @Bean
    fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner {
        return CommandLineRunner {
            println("Beans provided by Spring Boot:")
            val beansNames = ctx.beanDefinitionNames.sorted()
            beansNames.forEach(::println)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<KotlinSpringApplication>(*args)
}
