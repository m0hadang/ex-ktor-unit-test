package com.example.exktorunittest.service

import mu.KotlinLogging
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class CalcServiceTest(
    @Autowired
    private val calcService: CalcService
) {
    val logger = KotlinLogging.logger {}

    @Test
    fun `add test`() {
        logger.info("!!! start add test !!!")
        val a = 1L
        val b = 2L
        assertEquals(3, calcService.add(a, b))
    }
}