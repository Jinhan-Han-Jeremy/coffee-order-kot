package com.example.coffeeorderkot.user.domain

import com.example.coffeeorderkot.common.CoffeeShopBadRequestException
import com.example.coffeeorderkot.common.CoffeeShopErrors.INSUFFICIENT_USER_POINT
import jakarta.persistence.*
import lombok.AccessLevel
import lombok.Getter
import lombok.NoArgsConstructor


@Entity
@Table(name = "`user`")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val userSeq: Long? = null
    private var userId: String
    private var userPoint: Long

    constructor(userId: String) {
        this.userId = userId
        userPoint = 0L
    }

    constructor(userId: String, userPoint: Long) {
        this.userId = userId
        this.userPoint = userPoint
    }

    fun usePoint(usingPoint: Long) {
        if (userPoint < usingPoint) {
            throw CoffeeShopBadRequestException(INSUFFICIENT_USER_POINT)
        }
        userPoint -= usingPoint
    }

    fun chargePoint(chargingPoint: Long) {
        userPoint += chargingPoint
    }
}

