package org.backend.model

import jakarta.persistence.*

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val email: String,
    val password: String,
    val name: String,
    val address: String,
    val phone: String,
    val role: String = "CUSTOMER"
)
