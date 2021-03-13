package com.resteaxm.product.config

import com.resteaxm.product.User.User
import com.resteaxm.product.User.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.persistence.PostPersist
import javax.persistence.PostUpdate

@Component
class UserListener {

    @PostPersist
    fun postPersist(user: User) {
        println("===========================")
        println("user: $user")
        println("===========================")
    }

    @PostUpdate
    fun postUpdate(user: User) {
        println("===========================")
        println("user: $user")
        println("===========================")
    }
}