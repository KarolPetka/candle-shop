package org.backend.config

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtil(
    @Value("\${jwt.secret}") private val jwtSecret: String,
    @Value("\${jwt.expiration}") private val jwtExpiration: Long
) {

    fun generateToken(email: String, role: String): String {
        val now = Date()
        val expiryDate = Date(now.time + jwtExpiration)

        val key = Keys.hmacShaKeyFor(jwtSecret.toByteArray())  // Generate the SecretKey

        return Jwts.builder()
            .setSubject(email)
            .claim("role", role)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(key)
            .compact()
    }

    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parser().setSigningKey(jwtSecret.toByteArray()).parseClaimsJws(token)
            true
        } catch (ex: Exception) {
            false
        }
    }

    fun getEmailFromToken(token: String): String {
        return Jwts.parser().setSigningKey(jwtSecret.toByteArray()).parseClaimsJws(token).body.subject
    }

    fun getRoleFromToken(token: String): String {
        val claims = Jwts.parser().setSigningKey(jwtSecret.toByteArray()).parseClaimsJws(token).body
        return claims["role"].toString()
    }
}
