package com.example.coffeeorderkot.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfig {
    @Bean
    fun springShopOpenAPI(): OpenAPI {
        return OpenAPI()
            .addServersItem(Server().url("/"))
            .components(Components())
            .info(
                Info()
                    .title("Coffee Order API List")
                    .description("커피 주문 시스템 API 목록")
                    .version("v.0.0.1")
            )
    }
}
