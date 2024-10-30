package org.backend.service

import org.backend.model.Product
import org.backend.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class StockService(private val productRepository: ProductRepository) {

    fun getStock(productId: Long): Int {
        val product = productRepository.findById(productId).orElseThrow { IllegalArgumentException("Product not found") }
        return product.stock
    }

    fun getLowStockProducts(threshold: Int = 5): List<Product> {
        return productRepository.findAll().filter { it.stock < threshold }
    }
}
