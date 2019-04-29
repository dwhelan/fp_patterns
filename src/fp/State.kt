package fp

data class State(val processor: Processor = LowerCase(), val count: Int = 0) {}

data class Result(val string: String, val state: State) {}

class Context {
    fun echo(string: String) = echo(string, State())
    fun echo(string: String, state: State) = state.processor.echo(string, state)
}

interface Processor {
    fun echo(string: String, state: State): Result
}

class LowerCase : Processor {
    override fun echo(string: String, state: State) =
        Result(string.toLowerCase(), State(UpperCase(), 0))
}

class UpperCase : Processor {
    override fun echo(string: String, state: State): Result {
        if (beenHereBefore(state)) {
            return Result(string.toUpperCase(), State(LowerCase(), 0))
        } else {
            return Result(string.toUpperCase(), State(UpperCase(), state.count + 1))
        }
    }

    private fun beenHereBefore(state: State) =  state.count > 0
}
