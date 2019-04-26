package oo_test

import Light
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class CommandTest {

    @Test fun turn_light_on() {
        val light = Light()
        light.on()
        assertTrue(light.isOn())
        assertFalse(light.isOff())
    }
}

