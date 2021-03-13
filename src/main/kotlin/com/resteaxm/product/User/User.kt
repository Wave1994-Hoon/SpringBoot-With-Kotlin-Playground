package com.resteaxm.product.User

import com.resteaxm.product.config.UserListener
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@EntityListeners(value= [UserListener::class])
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String,
    val checked: Boolean? = null,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null
)
