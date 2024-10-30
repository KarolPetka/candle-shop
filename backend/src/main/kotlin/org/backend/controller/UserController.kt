package org.backend.controller

import org.backend.model.User
import org.backend.model.LoginRequest
import org.backend.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserController(private val userService: UserService) {

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    fun registerUser(@RequestBody user: User): Long = userService.register(user).id

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    fun loginUser(@RequestBody request: LoginRequest): String {
        return userService.login(request.email, request.password)
    }
}