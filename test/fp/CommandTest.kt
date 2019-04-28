package fp

import Door
import Light

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CommandTest {
    val light = Light()
    val door = Door()

    @Test fun turn_on_light() {
        turnOn(light)()
        assertTrue(light.on)
    }

    @Test fun greet_at_door() {
        greet(door, "hello")()
        assertEquals("hello", door.message)
    }

    @Test fun sequencer() {
        sequencer(listOf(turnOn(light), greet(door, "hello")))()

        assertTrue(light.on)
        assertEquals("hello", door.message)
    }
}
