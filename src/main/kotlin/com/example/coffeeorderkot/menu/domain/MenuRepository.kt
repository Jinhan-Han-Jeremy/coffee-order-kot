package com.example.coffeeorderkot.menu.domain

import org.springframework.data.jpa.repository.JpaRepository


interface MenuRepository : JpaRepository<Menu?, Long?>
