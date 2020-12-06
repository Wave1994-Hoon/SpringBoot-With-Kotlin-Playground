package com.resteaxm.product

import java.time.OffsetDateTime
import javax.persistence.*

enum class Category {
    Phone, Laptop, Keyboard
}

@Entity
data class Product (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
//    @Enumerated(EnumType.STRING)
    val category: Category,
    val isAvailable: Boolean? = false,
    val createDateTime: OffsetDateTime = OffsetDateTime.now(),
    var updateDateTime: OffsetDateTime? = null
) {
    fun toReadProductDTO(): ReadProductDTO {
        return ReadProductDTO(
            id = id,
            name = name,
            category =  category,
            isAvailable = isAvailable
        )
    }

    fun toCreateProductDTO(): CreateProductDTO {
        return CreateProductDTO(
            name = name,
            category = category
        )
    }
}

