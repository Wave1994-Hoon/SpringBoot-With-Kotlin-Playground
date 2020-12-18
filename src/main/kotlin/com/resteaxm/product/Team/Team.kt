package com.resteaxm.product.Team

import com.resteaxm.product.Locker.Locker
import com.resteaxm.product.Member.Member
import javax.persistence.*

@Entity
data class Team(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID")
    var id: Long? = null,

    val name: String,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    val locker: List<Locker> = arrayListOf(),

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    val member: List<Member> = arrayListOf()
)