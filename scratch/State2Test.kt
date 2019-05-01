package fp2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class State2Test {
    @Test fun starts_in_lower_case() {
        assertEquals("abc", echo("ABC").string)
    }

    @Test fun after_one_switches_to_upper_case() {
        val result = echo("")
        assertEquals("ABC", echo("abc", result.state).string)
    }

    @Test fun after_two_stays_in_upper_case() {
        var result = echo("")
        result = echo("", result.state)
        assertEquals("ABC", echo("abc", result.state).string)
    }

    @Test fun after_three_switches_to_lower_case() {
        var result = echo("")
        result = echo("", result.state)
        result = echo("", result.state)
        assertEquals("abc", echo("ABC", result.state).string)
    }
}
