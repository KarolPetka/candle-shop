package org.backend.controller

import org.backend.model.Product
import org.backend.service.StockService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product")
class StockController(private val stockService: StockService) {

    @GetMapping("/{productId}/stock")
    fun getStock(@PathVariable productId: Long): Map<String, Int> {
        val stock = stockService.getStock(productId)
        return mapOf("stock" to stock)
    }

    @GetMapping("/low-stock")
    fun getLowStockProducts(): List<Product> {
        return stockService.getLowStockProducts()
    }
}