package org.backend.controller

import org.backend.model.Order
import org.backend.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/order")
class OrderController(private val orderService: OrderService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createOrder(@RequestBody order: Order): Long = orderService.createOrder(order).id

    @GetMapping("/{orderId}")
    fun getOrderStatus(@PathVariable orderId: Long): Map<String, String> {
        val status = orderService.getOrderStatus(orderId)
        return mapOf("status" to status)
    }

    @PutMapping("/{orderId}/status")
    fun updateOrderStatus(@PathVariable orderId: Long, @RequestBody request: Map<String, String>): Order {
        val status = request["status"] ?: throw IllegalArgumentException("Status is required")
        return orderService.updateOrderStatus(orderId, status)
    }
}