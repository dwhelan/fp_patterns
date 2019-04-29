package fp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StateTest {
    private val context = Context()

    @Test fun starts_in_lower_case() {
        assertEquals("abc", context.echo("ABC").string)
    }

    @Test fun after_lower_case_switches_to_upper_case() {
        val result = context.echo("")
        assertEquals("ABC", context.echo("abc", result.state).string)
    }

    @Test fun after_one_upper_case_stays_in_upper_case() {
        var result = context.echo("")
        result = context.echo("", result.state)

        assertEquals("ABC", context.echo("abc", result.state).string)
    }

    @Test fun after_two_upper_cases_switches_to_lower_case() {
        var result = context.echo("")
        result = context.echo("", result.state)
        result = context.echo("", result.state)

        assertEquals("abc", context.echo("ABC", result.state).string)
    }
}
