package org.backend.controller

import org.backend.model.Category
import org.backend.service.CategoryService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/category")
class CategoryController(private val categoryService: CategoryService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addCategory(@RequestBody category: Category): Long = categoryService.addCategory(category).id
}
