package org.backend.repository

import org.backend.model.ShippingOption
import org.springframework.data.jpa.repository.JpaRepository

interface ShippingOptionRepository : JpaRepository<ShippingOption, Long>
