package com.example.kotlinonebutton

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Test
//import kotlin.coroutines.EmptyCoroutineContext.plus

class PlusTest {
    private lateinit var plus: Plus

    @Before
    fun setUp(){
        plus = Plus()
    }

    @Test
    fun `test penambahan`() {
        val hasil = plus.add(10.0, 5.0);
        assertEquals(15.0, hasil, "10 + 5 seharusnya 15")
    }

    @Test
    fun `test penambahan negatip`() {
        assertEquals(0.0, plus.add(-2.0,2.0))
        assertEquals(-10, plus.add(5.0, 15.0))
    }
}