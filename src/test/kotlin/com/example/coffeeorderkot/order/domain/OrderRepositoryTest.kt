package com.example.coffeeorderkot.order.domain

import com.example.coffeeorderkot.menu.application.MenuDto
import com.example.coffeeorderkot.user.domain.User
import com.example.coffeeorderkot.user.domain
import jakarta.transaction.Transactional
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.time.LocalDateTime


@ActiveProfiles("test")
@SpringBootTest
@Transactional
internal class OrderRepositoryTest {
    @Autowired
    private val orderRepository: OrderRepository? = null

    @Autowired
    private val userRepository: UserRepository? = null
    @BeforeEach
    fun setUp() {
        userRepository.save(User("livelysb"))
    }

    @Test
    fun save() {
        // given
        val order = Order(OrderRequest(MenuDto(1L, "아이스 아메리카노", 4200L), "livelysb"))

        // when
        val savedOrder: Order = orderRepository.save(order)

        // then
        Assertions.assertEquals(savedOrder.getMenuId(), 1L)
        Assertions.assertEquals(savedOrder.getMenuName(), "아이스 아메리카노")
        Assertions.assertEquals(savedOrder.getOrderPrice(), 4200L)
        Assertions.assertTrue(savedOrder.getOrderedAt().isBefore(LocalDateTime.now()))
    }
}