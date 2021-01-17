package com.resteaxm.product.User

import com.resteaxm.product.Member.Member
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long> {
//    fun findByTag(tag: String): List<User>
}