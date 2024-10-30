package org.backend.controller

import org.backend.model.ProductReview
import org.backend.service.ProductReviewService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/product/{productId}/review")
class ProductReviewController(private val productReviewService: ProductReviewService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addReview(@PathVariable productId: Long, @RequestBody review: ProductReview): Long {
        return productReviewService.addReview(productId, review).id
    }
}