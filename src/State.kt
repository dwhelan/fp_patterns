
typealias Echoer = (String, State) -> Result

fun echo(string: String, state: State = State(lowerCase)) =
    state.echoer(string, state)

data class Result(val string: String, val state: State) {}

data class State(var echoer: Echoer, val count: Int = 0) {}

val lowerCase: Echoer = { string, state ->
    state.echoer = upperCase
    Result(string.toLowerCase(), state)
}

val upperCase: Echoer = { string, state ->
    var count = state.count + 1
    fun isSecondTime() = 1 < count
    if (isSecondTime())
        state.echoer = lowerCase
    Result(string.toUpperCase(), State(state.echoer, count))
}

