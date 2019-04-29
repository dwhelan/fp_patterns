package fp

data class Result(val string: String, val state: State) {}

data class State(val processor: Processor, val data: Int = 0) {}

fun echo(string: String, state: State = State(LowerCase())) =
    state.processor.echo(string, state)

interface Processor {
    fun echo(string: String, state: State): Result
}

class LowerCase : Processor {
    override fun echo(string: String, state: State) =
        Result(string.toLowerCase(), State(UpperCase()))
}

class UpperCase : Processor {
    override fun echo(string: String, state: State) =
        Result(string.toUpperCase(), transitions(state))

    private fun transitions(state: State): State {
        if (state.data > 0) {
            return State(LowerCase())
        } else {
            return State(UpperCase(), state.data + 1)
        }
    }

}
