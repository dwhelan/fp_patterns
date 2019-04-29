package fp

enum class Mode { LOWER, UPPER }

data class State(internal val mode: Mode, internal val count: Int) {}

data class Result(val string: String, val state: State) {}

class Processor {
    companion object {
        fun result(string: String) = result(string, Mode.LOWER, 0)
        fun result(string: String, mode: Mode, count: Int) = Result(string, State(mode, count))
    }

    fun echo(string: String) = lowerCase(result(string))

    fun echo(result: Result) =
        when (result.mode) {
            Mode.LOWER -> lowerCase(result)
            else       -> upperCase(result)
        }

    private fun lowerCase(result: Result) =
        result(result.string.toLowerCase(), Mode.UPPER, 0)

    private fun upperCase(echo: Result) =
        when (echo.count) {
            0    -> result(echo.string.toUpperCase(), Mode.UPPER, echo.count + 1)
            else -> result(echo.string.toUpperCase())
        }
}

val Result.mode   get() = this.state.mode
val Result.count  get() = this.state.count

fun Result.string(string: String) = Result(string, state)
