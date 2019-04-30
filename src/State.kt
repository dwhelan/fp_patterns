typealias Echoer = (String, State) -> Result

data class State(val echoer: Echoer, val count: Int = 0) {}

data class Result(val string: String, val state: State) {}

fun echo(string: String, state: State = State(lowerCase)) =
    state.echoer(string, state)

val lowerCase: Echoer = { string, state ->
    Result(string.toLowerCase(), State(upperCase))
}

val upperCase: Echoer = { string, state ->
    if (0 < state.count)
        Result(string.toUpperCase(), State(lowerCase))
    else
        Result(string.toUpperCase(), State(state.echoer, state.count + 1))
}
