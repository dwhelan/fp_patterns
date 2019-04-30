package fp

data class Result(val string: String, val state: State) {}

data class State(val mode: Echo, val data: Int = 0) {}

enum class Echo { lower, upper }

val echoers = mapOf<Echo, (String, State) -> Result> (
    Echo.lower to ::doLowerCase,
    Echo.upper to ::doUpperCase
)

fun echo(string: String, state: State = State(Echo.lower)) =
    echoers[state.mode]!!.invoke(string, state)

fun doLowerCase(string: String, state: State) = Result(
    string.toLowerCase(),
    State(Echo.upper)
)

fun doUpperCase(string: String, state: State) = Result(
    string.toUpperCase(),
    if (state.data > 0)
        State(Echo.lower)
    else
        State(Echo.upper, state.data + 1)
)
