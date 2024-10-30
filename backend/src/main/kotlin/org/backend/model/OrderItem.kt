package org.backend.model

import jakarta.persistence.*

@Entity
data class OrderItem(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @ManyToOne @JoinColumn(name = "product_id")
    val product: Product,
    val quantity: Int
)
