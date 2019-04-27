package oo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SingletonTest {

    @Test fun instance() {
        val instance = Singleton.instance

        assertNotNull(instance)
        assertSame(instance, Singleton.instance)
    }
}

