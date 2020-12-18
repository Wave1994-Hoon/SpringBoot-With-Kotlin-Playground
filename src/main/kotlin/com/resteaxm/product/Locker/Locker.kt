package com.resteaxm.product.Locker

import com.resteaxm.product.Team.Team
import javax.persistence.*

@Entity
data class Locker(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCKER_ID")
    var id: Long? = null,

    val name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    val team: Team
)