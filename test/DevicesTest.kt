import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LightTest {
    var light : Light = Light()

    @Test fun turn_light_on() {
        light.on()
        assertTrue(light.isOn())
    }

    @Test fun turn_light_off() {
        light.off()
        assertFalse(light.isOn())
    }
}

class DoorTest {
    var door : Door = Door()

    @Test internal fun open_door() {
        door.open()
        assertTrue(door.isOpen())
    }

    @Test internal fun close_door() {
        door.close()
        assertFalse(door.isOpen())
    }

    @Test internal fun greet() {
        door.greet("hello")
        assertEquals("hello", door.message)
    }
}

