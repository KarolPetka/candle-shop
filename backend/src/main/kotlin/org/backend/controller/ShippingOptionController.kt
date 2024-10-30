package org.backend.controller

import org.backend.model.ShippingOption
import org.backend.service.ShippingOptionService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/shipping-option")
class ShippingOptionController(private val shippingOptionService: ShippingOptionService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addShippingOption(@RequestBody shippingOption: ShippingOption): Long = shippingOptionService.addShippingOption(shippingOption).id
}
