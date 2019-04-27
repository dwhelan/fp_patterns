package fp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StateTest {
    private val processor = Processor()

    @Test fun `starts in lower case state`() {
        val result = processor.echo("A")
        assertEquals("a", result.first)
    }

    @Test fun `after one call is in upper case state`() {
        val result1 : Pair<String, State> = processor.echo("")
        val result : Pair<String, State> = processor.echo(Pair("a", result1.second))
        assertEquals("A", result.first)
    }

    @Test fun `after two calls is still in upper case state`() {
        val result1 : Pair<String, State> = processor.echo("")
        val result2 : Pair<String, State> = processor.echo(Pair("", result1.second))
        val result : Pair<String, State> = processor.echo(Pair("a", result2.second))
        assertEquals("A", result.first)
    }

    @Test fun `after three calls is back in lower case state`() {
        val result1 : Pair<String, State> = processor.echo("1")
        val result2 : Pair<String, State> = processor.echo(Pair("2", result1.second))
        val result3 : Pair<String, State> = processor.echo(Pair("3", result2.second))
        val result : Pair<String, State> = processor.echo(Pair("A", result3.second))
        assertEquals("a", result.first)
    }
}
