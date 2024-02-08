package com.example.coffeeorderkot

import org.junit.jupiter.api.AfterEach

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import java.util.function.Consumer

@SpringBootTest
class DatabaseCleanUpExecutor {
    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    @AfterEach
    public fun tearDown() {

    }

    private fun getTruncateQueries(jdbcTemplate: JdbcTemplate): List<String> {
        return jdbcTemplate.queryForList(
            "SELECT Concat('TRUNCATE TABLE `', TABLE_NAME, '`;') AS q " +
                    "FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PUBLIC'",
            String::class.java
        )
    }

    private fun truncateTables(jdbcTemplate: JdbcTemplate, truncateQueries: List<String>) {
        execute(jdbcTemplate, "SET REFERENTIAL_INTEGRITY FALSE")
        truncateQueries.forEach(Consumer { v: String? -> execute(jdbcTemplate, v!!)
        })
        execute(jdbcTemplate, "SET REFERENTIAL_INTEGRITY TRUE")
    }

    private fun execute(jdbcTemplate: JdbcTemplate, query: String) {
        jdbcTemplate.execute(query)
    }
}
