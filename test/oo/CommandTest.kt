package fp_test

import Door
import Light
import oo.*
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class `FP light commands` {
    private val light = Light()

    @Test fun turn_light_on() {
        val command = TurnLightOn(light)
        command.execute()

        assertTrue(light.isOn())
        assertFalse(light.isOff())
    }

    @Test fun turn_light_off() {
        val command = TurnLightOff(light)
        command.execute()

        assertTrue(light.isOff())
        assertFalse(light.isOn())
    }
}

internal class `FP door commands` {
    private val door = Door()

    @Test fun open_door() {
        val command = OpenDoor(door)
        command.execute()

        assertTrue(door.isOpen())
        assertFalse(door.isClosed())
    }

    @Test fun close_door() {
        val command = CloseDoor(door)
        command.execute()

        assertTrue(door.isClosed())
        assertFalse(door.isOpen())
    }
}

internal class `FP command list` {
    private val door = Door()
    private val light = Light()

    @Test fun execute() {
        val command = CommandList(listOf(OpenDoor(door), TurnLightOn(light)))
        command.execute()

        assertTrue(door.isOpen())
        assertTrue(light.isOn())
    }
}
