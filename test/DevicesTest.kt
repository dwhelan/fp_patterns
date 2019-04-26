package oo_test

import Light
import Door
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class LightTest {
    private var light : Light = Light()

    @BeforeEach fun setup() {
        light = Light()
    }

    @Test fun turn_light_on() {
        light.on()
        assertTrue(light.isOn())
        assertFalse(light.isOff())
    }

    @Test fun turn_light_off() {
        light.off()
        assertTrue(light.isOff())
        assertFalse(light.isOn())
    }
}

internal class DoorTest {
    private var door : Door = Door()

    @BeforeEach fun setup() {
        door = Door()
    }

    @Test internal fun open_door() {
        door.open()
        assertTrue(door.isOpen())
        assertFalse(door.isClosed())
    }

    @Test internal fun close_door() {
        door.close()
        assertTrue(door.isClosed())
        assertFalse(door.isOpen())
    }
}

