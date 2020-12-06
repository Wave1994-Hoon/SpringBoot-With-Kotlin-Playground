package com.resteaxm.product


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer


@SpringBootApplication
class ProductApplication: SpringBootServletInitializer()

fun main(args: Array<String>) {

    runApplication<ProductApplication>(*args)
}
