
fun echo(string: String, state: State = State()) =
    state.echoer.echo(string, state)

data class Result(val string: String, val state: State) {}

data class State(var echoer: Echo = LowerCase(), val count: Int = 0) {}

interface Echo {
    fun echo(string: String, state: State): Result
}

class LowerCase : Echo {
    override fun echo(string: String, state: State): Result {
        state.echoer = UpperCase()
        return Result(string.toLowerCase(), state)
    }
}

class UpperCase : Echo {
    override fun echo(string: String, state: State): Result {
        var count = state.count + 1
        fun isSecondTime() = 1 < count
        if (isSecondTime())
            state.echoer = LowerCase()
        return Result(string.toUpperCase(), State(state.echoer, count))
    }
}
