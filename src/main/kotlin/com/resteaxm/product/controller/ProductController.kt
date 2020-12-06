package com.resteaxm.product.controller

import com.resteaxm.product.CreateProductDTO
import com.resteaxm.product.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ProductController {

    @Autowired
    private lateinit var productService: ProductService

    @GetMapping("/products", produces = ["application/json"])
    fun getProducts(): ResponseEntity<Any> {

        return ResponseEntity
            .ok()
            .body(productService.getProducts())
    }

    @PostMapping("/product")
    fun createProduct(@RequestBody createProductDTO: CreateProductDTO): ResponseEntity<Any> {
        productService.createProduct(createProductDTO)
        return ResponseEntity
            .ok()
            .body(true)
    }
}

@RestController
@RequestMapping("/api/v1/health", produces = ["application/json"])
class HealthCheckRestController {

    @GetMapping("/hello")
    fun hello(
    ): ResponseEntity<Any> {
        return ResponseEntity.ok("ok")
    }
}

