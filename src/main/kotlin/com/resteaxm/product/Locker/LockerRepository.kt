package com.resteaxm.product.Locker

import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface LockerRepository: CrudRepository<Locker, Long> {

//    @Query("select l from Locker l left join fetch l.member where l.id = :lockerId")
//    fun findByIdWithFetchJoin(lockerId: Long): Locker
//
//    @EntityGraph(attributePaths = ["member"])
//    @Query("select l from Locker l where l.id = :lockerId")
//    fun findByIdWithEntityGraph(lockerId: Long): Locker
//
//    @EntityGraph(attributePaths = ["member"])
//    fun findTopById(lockerId: Long): Locker
}








