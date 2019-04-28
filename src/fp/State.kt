package fp

enum class Mode { LOWER, UPPER }

data class State(internal val mode: Mode, internal val count: Int) {}

typealias Echo = Pair<String, State>

class Processor {
    fun echo(string: String) = lowerCase(string)

    fun echo(echo: Echo) =
        when (echo.mode) {
            Mode.LOWER -> lowerCase(echo.string)
            else       -> upperCase(echo.string, echo.count)
        }

    private fun lowerCase(string: String) =
        echo(string.toLowerCase(), Mode.UPPER, 0)

    private fun upperCase(string: String, count: Int) =
        when (count) {
            0    -> echo(string.toUpperCase(), Mode.UPPER, count + 1)
            else -> echo(string.toUpperCase(), Mode.LOWER, 0)
        }

    private fun echo(string: String, mode: Mode, count: Int) =
        Pair(string, State(mode, count))
}

val Echo.string get() = this.first
val Echo.state  get() = this.second
val Echo.mode   get() = this.state.mode
val Echo.count  get() = this.state.count

fun Echo.string(string: String) = Pair(string, this.state)
