package oo

import Door
import Light
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CommandTest {
    val light = Light()
    val door = Door()

    @Test fun turn_on_light() {
        TurnOn(light).execute()
        assertTrue(light.on)
    }

    @Test fun greet_at_door() {
        Greet(door, "hello").execute()
        assertEquals("hello", door.message)
    }

    @Test fun sequence() {
        Sequencer(listOf(TurnOn(light), Greet(door, "hello"))).execute()

        assertTrue(light.on)
        assertEquals("hello", door.message)
    }
}

