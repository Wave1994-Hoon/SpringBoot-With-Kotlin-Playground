package com.resteaxm.product

import com.resteaxm.product.Locker.Locker
import com.resteaxm.product.Locker.LockerRepository
import com.resteaxm.product.Member.MemberRepository
import com.resteaxm.product.Team.TeamRepository
import com.resteaxm.product.User.User
import com.resteaxm.product.User.UserRepository
import khttp.delete
import org.apache.commons.lang3.time.StopWatch
//import com.resteaxm.product.Team.TeamRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.event.EventListener
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager


@SpringBootApplication
class ProductApplication: SpringBootServletInitializer() {
}

fun main(args: Array<String>) {
    runApplication<ProductApplication>(*args)
}

@Component
//@Transactional(readOnly = true)
class StartTest {
//
//    @Autowired
//    private lateinit var userJdbcBatchRepository: UserJdbcBatchRepository

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var em: EntityManager

    @Autowired
    private lateinit var teamRepository: TeamRepository

    @EventListener
    fun onApplicationEvent(event: ApplicationStartedEvent) {
        val user1 = User(name = "user1")
        val user2 = User(name = "user2")
        val user3 = User(name = "user3")

        userRepository.save(user1)
        userRepository.save(user2)
        userRepository.save(user3)

        val user = userRepository.findById(1L).orElseThrow { throw Exception("") }
        user.name = "test"
        userRepository.save(user)
    }
}
