package com.example.coffeeorderkot.user.domain

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface UserRepository : JpaRepository<User?, Long?> {
    fun findByUserId(userId: String?): Optional<User?>?
}

