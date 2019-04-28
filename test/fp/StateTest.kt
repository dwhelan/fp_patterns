package fp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StateTest {
    private val processor = Processor()

    @Test fun `starts in lower case state`() {
        val result = processor.echo("ABC")

        assertEquals("abc", result.string)
    }

    @Test fun `after one call is in upper case state`() {
        val echo1 = processor.echo("")

        val result = processor.echo(echo1.string("abc"))

        assertEquals("ABC", result.string)
    }

    @Test fun `after two calls is still in upper case state`() {
        val echo1 = processor.echo("")
        val echo2 = processor.echo(echo1)

        val result = processor.echo(echo2.string("abc"))

        assertEquals("ABC", result.string)
    }

    @Test fun `after three calls is back in lower case state`() {
        val echo1 = processor.echo("")
        val echo2 = processor.echo(echo1)
        val echo3 = processor.echo(echo2)

        val result = processor.echo(echo3.string("ABC"))

        assertEquals("abc", result.string)
    }
}
