package com.resteaxm.product.Member

import com.resteaxm.product.Team.Team
import javax.persistence.*

@Entity
data class Member(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Member_ID")
    var id: Long? = null,

    @Column(name = "USERNAME")
    val userName: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    val team: Team
)
