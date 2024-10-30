package org.backend.controller

import org.backend.model.Product
import org.backend.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/product")
class ProductController(private val productService: ProductService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addProduct(@RequestBody product: Product): Long = productService.addProduct(product).id

    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    fun updateProduct(@PathVariable productId: Long, @RequestBody product: Product): Product =
        productService.updateProduct(productId, product)

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteProduct(@PathVariable productId: Long) {
        productService.deleteProduct(productId)
    }
}