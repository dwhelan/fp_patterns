import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.*

class StateTest {
    @Test fun starts_in_lower_case() {
        val result = echo("ABC")
        assertEquals("abc", result.string)
    }

    @Test fun after_one_switches_to_upper_case() {
        val result1 = echo("1")
        val result = echo("abc", result1.state)
        assertEquals("ABC", result.string)
    }

    @Test fun after_two_stays_in_upper_case() {
        val result1 = echo("1")
        val result2 = echo("2", result1.state)
        val result = echo("abc", result2.state)
        assertEquals("ABC", result.string)
    }

    @Test fun after_three_switches_to_lower_case() {
        val result1 = echo("1")
        val result2 = echo("2", result1.state)
        val result3 = echo("3", result2.state)
        val result = echo("ABC", result3.state)
        assertEquals("abc", result.string)
    }

    @Test fun after_five_stays_in_upper_case() {
        val result1 = echo("1")
        val result2 = echo("2", result1.state)
        val result3 = echo("3", result2.state)
        val result4 = echo("4", result3.state)
        val result5 = echo("5", result4.state)
        val result = echo("AbC", result5.state)
        assertEquals("ABC", result.string)
    }
}
