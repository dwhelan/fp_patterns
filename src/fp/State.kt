package fp

data class Result(val string: String, val state: State) {}

data class State(val name: EchoState, val data: Int = 0) {}

fun echo(string: String, state: State = State(LowerCase())) =
    state.name.echo(string, state)

interface EchoState {
    fun echo(string: String, state: State): Result
}

class LowerCase : EchoState {
    override fun echo(string: String, state: State) =
        Result(string.toLowerCase(), State(UpperCase()))
}

class UpperCase : EchoState {
    override fun echo(string: String, state: State) =
        Result(
            string.toUpperCase(),
            if (state.data > 0) {
                State(LowerCase())
            } else {
                State(UpperCase(), state.data + 1)
            }
        )
}
