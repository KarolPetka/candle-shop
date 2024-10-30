package org.backend.service

import org.backend.config.JwtUtil
import org.backend.model.User
import org.backend.repository.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtUtil: JwtUtil
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val customer = userRepository.findByEmail(username)
            ?: throw UsernameNotFoundException("Customer not found with email: $username")

        return org.springframework.security.core.userdetails.User(
            customer.email,
            customer.password,
            listOf(SimpleGrantedAuthority(customer.role))
        )
    }

    fun register(user: User): User {
        val encodedCustomer = user.copy(password = passwordEncoder.encode(user.password))
        return userRepository.save(encodedCustomer)
    }

    fun login(email: String, password: String): String {
        val customer =
            userRepository.findByEmail(email) ?: throw IllegalArgumentException("Invalid email or password")
        if (!passwordEncoder.matches(
                password,
                customer.password
            )
        ) throw IllegalArgumentException("Invalid email or password")

        return jwtUtil.generateToken(email, customer.role)
    }
}
