package org.backend.model

import jakarta.persistence.*

@Entity
@Table(name = "orders")
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val customerId: String,
    @OneToMany(cascade = [CascadeType.ALL])
    val products: List<OrderItem>,
    var status: String = "Pending",
    val shippingOption: String,
    val paymentMethod: String
)


