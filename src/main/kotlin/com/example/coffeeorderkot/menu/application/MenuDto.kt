package com.example.coffeeorderkot.menu.application

import io.swagger.v3.oas.annotations.media.Schema
import lombok.AllArgsConstructor
import lombok.Getter

@Getter
@AllArgsConstructor
@Schema(description = "메뉴")
class MenuDto {
    @Schema(description = "메뉴 ID")
    private val menuId: Long? = null

    @Schema(description = "메뉴명", example = "아이스 아메리카노")
    private val menuName: String? = null

    @Schema(description = "메뉴 가격")
    private val menuPrice: Long? = null
}

