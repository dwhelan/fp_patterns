import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LightTest {
    var light = Light()

    @Test fun turn_on() {
        light.on()
        assertTrue(light.on)
    }
}

class DoorTest {
    var door = Door()

    @Test fun open() {
        door.open()
        assertTrue(door.open)
    }

    @Test fun greet() {
        door.greet("hello")
        assertEquals("hello", door.message)
    }
}
