package fp

enum class Mode { LOWER, UPPER }

data class State(internal val mode: Mode, internal val count: Int) {}

typealias Echo = Pair<String, State>

class Processor {
    companion object {
        fun init(string: String) = result(string, Mode.LOWER, 0)
        fun result(string: String, mode: Mode, count: Int) = Pair(string, State(mode, count))
    }

    fun echo(string: String) = lowerCase(init(string))

    fun echo(echo: Echo) =
        when (echo.mode) {
            Mode.LOWER -> lowerCase(echo)
            else       -> upperCase(echo)
        }

    fun lets() {
        "code"
    }

    private fun lowerCase(echo: Echo) =
        result(echo.string.toLowerCase(), Mode.UPPER, 0)

    private fun upperCase(echo: Echo) =
        when (echo.count) {
            0    -> result(echo.string.toUpperCase(), Mode.UPPER, echo.count + 1)
            else -> init(echo.string.toUpperCase())
        }
}

val Echo.string get() = this.first
val Echo.state  get() = this.second
val Echo.mode   get() = this.state.mode
val Echo.count  get() = this.state.count

fun Echo.string(string: String) = Pair(string, this.state)
