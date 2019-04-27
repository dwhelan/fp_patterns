package fp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SingletonTest {

    @Test fun instance() {
        val instance = singleton()

        assertNotNull(instance)
        assertSame(instance, singleton())
    }
}

