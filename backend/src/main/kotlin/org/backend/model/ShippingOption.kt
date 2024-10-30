package org.backend.model

import jakarta.persistence.*

@Entity
data class ShippingOption(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val price: Double,
    val estimatedDelivery: String
)
