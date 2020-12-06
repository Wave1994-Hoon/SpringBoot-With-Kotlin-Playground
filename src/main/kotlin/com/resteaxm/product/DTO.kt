package com.resteaxm.product

data class ReadProductDTO (
    val id: Long? = null,
    val name: String,
    val category: Category,
    val isAvailable: Boolean?
)

data class CreateProductDTO (
    val name: String,
    val category: Category
) {
    fun toEntity(): Product {
        return Product(
            name = name,
            category = category
        )
    }
}

