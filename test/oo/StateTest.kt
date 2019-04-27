package oo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StateTest {
    private val context = StateContext()

    @Test fun starts_in_lower_case() {
        assertEquals("x", context.writeName("X"))
    }

    @Test fun after_lower_case_switches_to_upper_case() {
        context.writeName("in lower")
        assertEquals("X", context.writeName("x"))
    }

    @Test fun after_two_upper_cases_switches_to_lower_case() {
        context.writeName("in lower")
        context.writeName("in upper")
        context.writeName("in upper")
        assertEquals("x", context.writeName("X"))
    }
}
