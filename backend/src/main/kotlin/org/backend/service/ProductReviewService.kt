package org.backend.service

import org.backend.model.ProductReview
import org.backend.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductReviewService(private val productRepository: ProductRepository) {

    fun addReview(productId: Long, review: ProductReview): ProductReview {
        val product = productRepository.findById(productId).orElseThrow { IllegalArgumentException("Product not found") }
        product.reviews.add(review)
        productRepository.save(product)
        return review
    }
}