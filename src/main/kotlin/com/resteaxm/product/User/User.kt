package com.resteaxm.product.User

import javax.persistence.*


@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val name: String
)
