package com.example.coffeeorderkot.menu.domain

import com.example.coffeeorderkot.menu.application.MenuDto

import jakarta.persistence.*
import lombok.AccessLevel
import lombok.Getter
import lombok.NoArgsConstructor

@Entity
@Table(name = "menu")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val menuId: Long? = null,
    private val menuName: String? = null,
    private val menuPrice: Long? = null
) {
    constructor(menuName: String, menuPrice: Long) : this(null, menuName, menuPrice)

    fun toDto(): MenuDto {
        return MenuDto(menuId, menuName, menuPrice)
    }
}
