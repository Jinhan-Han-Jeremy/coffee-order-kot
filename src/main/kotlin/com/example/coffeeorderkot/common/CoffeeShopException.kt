package com.example.coffeeorderkot.common

import lombok.Getter


@Getter
class CoffeeShopException(error: CoffeeShopErrors) : RuntimeException() {
    private val error: CoffeeShopErrors

    init {
        this.error = error
    }
}
