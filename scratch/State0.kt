package fp0

fun echo(string: String, state: State = State(Echo.lower)) =
    echoers[state.mode]!!.invoke(string, state)

data class Result(val string: String, val state: State) {}

data class State(val mode: Echo, val data: Int = 0) {}

enum class Echo { lower, upper }

val echoers = mapOf<Echo, (String, State) -> Result>(
    Echo.lower to ::lowerCase,
    Echo.upper to ::upperCase
)

fun lowerCase(string: String, state: State) =
    Result(
        string.toLowerCase(),
        State(Echo.upper)
    )

fun upperCase(string: String, state: State) =
    Result(
        string.toUpperCase(),
        if (0 < state.data)
            State(Echo.lower)
        else
            State(Echo.upper, state.data + 1)
    )

