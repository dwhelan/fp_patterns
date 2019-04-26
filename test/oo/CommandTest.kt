package oo

import Door
import Light
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class `OO light commands` {
    val light = Light()

    @Test fun turn_on() {
        TurnOn(light).execute()
        assertTrue(light.isOn())
    }

    @Test fun turn_off() {
        TurnOff(light).execute()
        assertFalse(light.isOn())
    }
}

class `OO door commands` {
    val door = Door()

    @Test fun open() {
        Open(door).execute()
        assertTrue(door.isOpen())
    }

    @Test fun close() {
        Close(door).execute()
        assertFalse(door.isOpen())
    }

    @Test fun greet() {
        Greet(door, "hello").execute()
        assertEquals("hello", door.greeting)
    }
}

class `OO command list` {
    val door = Door()
    val light = Light()

    @Test fun execute() {
        Sequencer(listOf(Open(door), TurnOn(light), Greet(door, "hello"))).execute()

        assertTrue(door.isOpen())
        assertTrue(light.isOn())
        assertEquals("hello", door.greeting)
    }
}

