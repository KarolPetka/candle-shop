package org.backend.service

import org.backend.model.Product
import org.backend.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun getProduct(): List<Product> = productRepository.findAll()

    fun addProduct(product: Product): Product = productRepository.save(product)

    fun updateProduct(productId: Long, product: Product): Product {
        val existingProduct = productRepository.findById(productId).orElseThrow()
        return productRepository.save(
            existingProduct.copy(
                name = product.name,
                description = product.description,
                ingredients = product.ingredients,
                images = product.images,
                weight = product.weight,
                burnTime = product.burnTime,
                scents = product.scents,
                price = product.price,
                stock = product.stock,
                category = product.category
            )
        )
    }

    fun deleteProduct(productId: Long) = productRepository.deleteById(productId)

}
