private typealias Echoer = (String, State) -> Result

data class State(internal val echoer: Echoer = lowerCase, val count: Int = 0) {}

data class Result(val string: String, val state: State) {}

fun echo(string: String, state: State = State()) =
    state.echoer(string, state)

private val lowerCase: Echoer = { string, state ->
    Result(string.toLowerCase(), State(upperCase))
}

private val upperCase: Echoer = { string, state ->
    val nextState =
        if (0 < state.count)
            State(lowerCase)
        else
            state.copy(count = state.count + 1)
    Result(string.toUpperCase(), nextState)
}
