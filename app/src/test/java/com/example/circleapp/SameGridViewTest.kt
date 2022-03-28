package com.example.circleapp

import SameMaster
import junit.framework.Assert.assertTrue
import junit.framework.Assert.assertFalse
import org.junit.Test

class SameViewTest {
    @Test
    fun checkIfDoneT() = assertTrue(MainGame().checkIfDone(listOf(-1, -1, -1)))

    @Test
    fun checkIfDoneEmpty() = assertFalse(MainGame().checkIfDone(listOf()))

    @Test
    fun checkIfDoneF() = assertFalse(MainGame().checkIfDone(listOf(-1, 0, -1)))

}