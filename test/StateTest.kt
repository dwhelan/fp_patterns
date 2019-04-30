import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.*

class StateTest {
    @Test fun starts_in_lower_case() {
        assertEquals("abc", echo("ABC").string)
    }

    @Test fun after_one_switches_to_upper_case() {
        val result = echo("")
        assertEquals("ABC", echo("abc", result.state).string)
    }

    @Test fun after_two_stays_in_upper_case() {
        val result1 = echo("")
        val result2 = echo("", result1.state)
        assertEquals("ABC", echo("abc", result2.state).string)
    }

    @Test fun after_three_switches_to_lower_case() {
        val result1 = echo("")
        val result2 = echo("", result1.state)
        val result3 = echo("", result2.state)
        assertEquals("abc", echo("ABC", result3.state).string)
    }
}
