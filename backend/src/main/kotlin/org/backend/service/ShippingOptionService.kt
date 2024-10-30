package org.backend.service

import org.backend.model.ShippingOption
import org.backend.repository.ShippingOptionRepository
import org.springframework.stereotype.Service

@Service
class ShippingOptionService(private val shippingOptionRepository: ShippingOptionRepository) {

    fun addShippingOption(shippingOption: ShippingOption): ShippingOption = shippingOptionRepository.save(shippingOption)
}
