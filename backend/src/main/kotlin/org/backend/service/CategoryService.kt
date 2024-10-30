package org.backend.service

import org.backend.model.Category
import org.backend.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(private val categoryRepository: CategoryRepository) {

    fun addCategory(category: Category): Category = categoryRepository.save(category)
}
