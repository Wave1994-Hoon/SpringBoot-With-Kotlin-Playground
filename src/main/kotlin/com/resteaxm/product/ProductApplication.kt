package com.resteaxm.product

import com.resteaxm.product.Member.MemberRepository
import com.resteaxm.product.Team.TeamRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.event.EventListener
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@SpringBootApplication
class ProductApplication: SpringBootServletInitializer() {
}

fun main(args: Array<String>) {
    runApplication<ProductApplication>(*args)
}

@Component
@Transactional(readOnly = true)
class StartTest {

    @Autowired
    private lateinit var memberRepository: MemberRepository;

    @Autowired
    private lateinit var teamRepository: TeamRepository

    @EventListener
    fun onApplicationEvent(event: ApplicationStartedEvent) {
        val team = teamRepository.findByIdOrNull(1) ?: throw Exception("team is null")
        println("======================")

        val member = memberRepository.findByIdOrNull(1) ?: throw Exception("member is null")
        println("======================")

    }
}
