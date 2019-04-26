package oo

import Door
import Light
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class `OO light commands` {
    private val light = Light()

    @Test fun turn_light_on() {
        TurnOn(light).execute()
        assertTrue(light.isOn())
    }

    @Test fun turn_light_off() {
        TurnOff(light).execute()
        assertFalse(light.isOn())
    }
}

internal class `OO door commands` {
    private val door = Door()

    @Test fun open_door() {
        Open(door).execute()
        assertTrue(door.isOpen())
    }

    @Test fun close_door() {
        Close(door).execute()
        assertFalse(door.isOpen())
    }
}

internal class `OO command list` {
    private val door = Door()
    private val light = Light()

    @Test fun execute() {
        Sequencer(listOf(Open(door), TurnOn(light))).execute()

        assertTrue(door.isOpen())
        assertTrue(light.isOn())
    }
}

