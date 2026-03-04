package com.example.kotlinonebutton

import org.junit.Before
import org.junit.jupiter.api.Test
import kotlin.math.log
import kotlin.test.assertEquals

class LogicHitungTest {
    val a: Double = 5.0
    val b: Double = 3.0
    val tolerance: Double = 0.0
    private lateinit var logicHitung: LogicHitung
    @Before
    fun setup() {
        logicHitung = LogicHitung()
    }

    @Test
    fun testAdd() {
        val result = logicHitung.add(a, b)
        assertEquals(8.0, result, 0.0)
    }

    @Test
    fun testAddNegative(){
        val result = logicHitung.add(a, -15.0)
        assertEquals(-10.0, result, 0.0)
    }

    @Test
    fun testDecrement() {
        val result = logicHitung.decrement(a, b)
        assertEquals(2.0, result, tolerance)
    }

    @Test
    fun testDecrementtoNegative(){
        val result = logicHitung.decrement(b, a)
        assertEquals(-2.0, result, 0.0)
    }

    @Test
    fun testMultiple() {
        val result = logicHitung.multiple(a, b)
        assertEquals(15.0, result, tolerance)
    }

    @Test
    fun testDivision() {
        val result = logicHitung.division(6.0, b)
        assertEquals(2.0, result, tolerance)
    }

    @Test
    fun bagiNol(){
        val result = logicHitung.division(a, 0.0)
        assertEquals(0.0, result, tolerance)
    }
}