package com.example.coffeeorderkot.menu.domain

import jakarta.transaction.Transactional
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.junit.jupiter.api.Assertions.assertEquals

@ActiveProfiles("test")
@SpringBootTest
@Transactional
internal class MenuRepositoryTest {
    @Autowired
    private val menuRepository: MenuRepository? = null
    @Test
    fun save() {
        // given
        val menu = Menu("아이스 아메리카노", 4100L)

        // when
        val savedMenu: Menu = menuRepository.save(menu)

        // then
        Assertions.assertEquals(menu.getMenuName(), savedMenu.getMenuName())
        Assertions.assertEquals(menu.getMenuPrice(), savedMenu.getMenuPrice())
    }
}