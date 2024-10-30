package org.backend.model

import jakarta.persistence.*

@Entity
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val description: String,
    @ElementCollection
    val ingredients: List<String>,
    @ElementCollection
    val images: List<String>,
    val weight: Double,
    val burnTime: Int,
    @ElementCollection
    val scents: List<String>,
    val price: Double,
    val stock: Int,
    @ManyToOne @JoinColumn(name = "category_id")
    val category: Category,
    @OneToMany(cascade = [CascadeType.ALL])
    val reviews: MutableList<ProductReview> = mutableListOf()
)
