package fp

import Door
import Light

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `FP light commands` {
    val light = Light()

    @Test fun turn_on() {
        turnOn(light)()
        assertTrue(light.on)
    }

    @Test fun turn_off() {
        turnOff(light)()
        assertFalse(light.on)
    }
}

class `FP door commands` {
    val door = Door()

    @Test fun open() {
        open(door)()
        assertTrue(door.open)
    }

    @Test fun close() {
        close(door)()
        assertFalse(door.open)
    }

    @Test fun greet() {
        greet(door, "hello")()
        assertEquals("hello", door.message)
    }
}

class `FP command list` {
    val door = Door()
    val light = Light()

    @Test fun execute() {
        sequencer(listOf(open(door), turnOn(light), greet(door, "hello")))()

        assertTrue(door.open)
        assertTrue(light.on)
        assertEquals("hello", door.message)
    }
}
