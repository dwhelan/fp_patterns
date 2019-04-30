import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.*

class StateTest {
    @Test fun starts_in_lower_case() {
        assertEquals("abc", echo("ABC").string)
    }

    @Test fun after_one_switches_to_upper_case() {
        val context = Context()
        context.echo("", context)
        assertEquals("ABC", context.echo("abc", context).string)
    }

    @Test fun after_two_stays_in_upper_case() {
        val context = Context()
        context.echo("", context)
        context.echo("", context)
        assertEquals("ABC", context.echo("abc", context).string)
    }

    @Test fun after_three_switches_to_lower_case() {
        val context = Context()
        context.echo("", context)
        context.echo("", context)
        context.echo("", context)
        assertEquals("abc", context.echo("ABC", context).string)
    }
}
