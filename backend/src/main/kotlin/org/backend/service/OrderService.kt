package org.backend.service

import jakarta.transaction.Transactional
import org.backend.model.Order
import org.backend.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(private val orderRepository: OrderRepository) {

    fun createOrder(order: Order): Order = orderRepository.save(order)

    fun getOrderStatus(orderId: Long): String = orderRepository.findById(orderId).orElseThrow().status

    @Transactional
    fun updateOrderStatus(orderId: Long, status: String): Order {
        val order = orderRepository.findById(orderId).orElseThrow()
        order.status = status
        return orderRepository.save(order)
    }
}
