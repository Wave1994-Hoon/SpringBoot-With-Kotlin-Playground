package com.resteaxm.product.Member

import com.resteaxm.product.Locker.Locker
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface MemberRepository: CrudRepository<Member, Long> {
//    @Query("select l from Member l left join fetch l.locker where l.id = :memberId")
//    fun findByIdWithFetchJoin(memberId: Long): Member
}