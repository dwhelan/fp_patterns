
fun echo(string: String, state: State = State()) =
    state.state.echo(string, state)

data class Result(val string: String, val state: State) {}

data class State(var state: Echo = LowerCase()) {}

interface Echo {
    fun echo(string: String, state: State): Result
}

class LowerCase : Echo {
    override fun echo(string: String, state: State): Result {
        state.state = UpperCase()
        return Result(string.toLowerCase(), state)
    }
}

class UpperCase : Echo {
    private var count = 0

    override fun echo(string: String, state: State): Result {
        count++
        if (isSecondTime())
            state.state = LowerCase()
        return Result(string.toUpperCase(), state)
    }

    private fun isSecondTime() = 1 < count
}
