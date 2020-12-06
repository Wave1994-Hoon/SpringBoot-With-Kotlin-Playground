package com.resteaxm.product.service

import com.resteaxm.product.CreateProductDTO
import com.resteaxm.product.ProductRepository
import com.resteaxm.product.ReadProductDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Component
class ProductService {

    @Autowired
    lateinit var productRepository: ProductRepository

    fun getProducts(): List<ReadProductDTO> {
        val product = productRepository.findAll()
        return product.map { it.toReadProductDTO() }
    }

    @Transactional
    fun createProduct(createProductDTO: CreateProductDTO): CreateProductDTO {
        val product = productRepository.save(createProductDTO.toEntity())
        return product.toCreateProductDTO()
    }
}