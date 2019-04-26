package fp

import Door
import Light

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class `FP light commands` {
    val light = Light()

    @Test fun turn_light_on() {
        turnOn(light)()
        assertTrue(light.isOn())
    }

    @Test fun turn_light_off() {
        turnOff(light)()
        assertFalse(light.isOn())
    }
}

class `FP door commands` {
    val door = Door()

    @Test fun open() {
        open(door)()
        assertTrue(door.isOpen())
    }

    @Test fun close_door() {
        close(door)()
        assertFalse(door.isOpen())
    }
}

class `FP command list` {
    val door = Door()
    val light = Light()

    @Test fun execute() {
        sequencer(listOf(open(door), turnOn(light)))()

        assertTrue(door.isOpen())
        assertTrue(light.isOn())
    }
}
