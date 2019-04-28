import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DevicesTest {
    var light = Light()
    var door = Door()

    @Test fun turn_on() {
        light.on()
        assertTrue(light.on)
    }

    @Test fun greet() {
        door.greet("hello")
        assertEquals("hello", door.message)
    }
}
