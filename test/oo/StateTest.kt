package oo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StateTest {
    private val context = Context()

    @Test fun starts_in_lower_case() {
        assertEquals("x", context.echo("X"))
    }

    @Test fun after_lower_case_switches_to_upper_case() {
        context.echo("in lower")
        assertEquals("X", context.echo("x"))
    }

    @Test fun after_two_upper_cases_switches_to_lower_case() {
        context.echo("in lower")
        context.echo("in upper")
        context.echo("in upper")
        assertEquals("x", context.echo("X"))
    }
}
