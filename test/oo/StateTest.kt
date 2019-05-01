package oo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.*

class StateTest {
    @Test fun starts_in_lower_case() {
        val context = Context()
        assertEquals("abc", context.echo("Abc"))
    }

    @Test fun after_one_switches_to_upper_case() {
        val context = Context()
        context.echo("1")
        assertEquals("ABC", context.echo("Abc"))
    }

    @Test fun after_two_stays_in_upper_case() {
        val context = Context()
        context.echo("1")
        context.echo("2")
        assertEquals("ABC", context.echo("Abc"))
    }

    @Test fun after_three_switches_to_lower_case() {
        val context = Context()
        context.echo("1")
        context.echo("2")
        context.echo("3")
        assertEquals("abc", context.echo("Abc"))
    }
}
