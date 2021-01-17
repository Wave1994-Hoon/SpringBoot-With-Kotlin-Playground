package com.resteaxm.product

import com.resteaxm.product.Locker.Locker
import com.resteaxm.product.Locker.LockerRepository
import com.resteaxm.product.Member.MemberRepository
import com.resteaxm.product.Team.TeamRepository
import com.resteaxm.product.User.User
import com.resteaxm.product.User.UserJdbcBatchRepository
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

    @Autowired
    private lateinit var userJdbcBatchRepository: UserJdbcBatchRepository

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var em: EntityManager

    @Autowired
    private lateinit var teamRepository: TeamRepository

    @EventListener
    fun onApplicationEvent(event: ApplicationStartedEvent) {

        val users: MutableList<User> = mutableListOf();

        for (i in 1..3) {
            users.add(User(name = i.toString()))
//            userRepository.save(User(name = i.toString()))
        }
        userRepository.save(User(name = "aaaa"))

//        userRepository.saveAll(users)
        userJdbcBatchRepository.batchInsert1(users)


//        val findUsers: List<User> = userRepository.findByTag("A")
//        userJdbcBatchRepository.batchDelete(findUsers as MutableList<User>)
    }
}
