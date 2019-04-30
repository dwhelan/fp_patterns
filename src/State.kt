
fun echo(string: String, state: State = State()) =
    state.echoer.echo(string, state)

data class Result(val string: String, val state: State) {}

data class State(var echoer: Echo = LowerCase()) {}

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
    private var count = 0

    override fun echo(string: String, state: State): Result {
        count++
        if (isSecondTime())
            state.echoer = LowerCase()
        return Result(string.toUpperCase(), state)
    }

    private fun isSecondTime() = 1 < count
}
