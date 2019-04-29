package fp2

data class State(internal val processor: Processor, internal val count: Int) {}

data class Result(val string: String, val state: State) {}

class Context {
    internal var state: Processor = LowerCaseState()

    fun echo(string: String) = state.echo(string, this)
}

interface Processor {
    fun echo(string: String, context: Context): Result
}

class LowerCaseState : Processor {
    override fun echo(string: String, context: Context): Result {
        context.state = UpperCaseState()
        return Result(string.toLowerCase(), State(UpperCaseState(), 0))
    }
}

class UpperCaseState : Processor {
    private var count = 0

    override fun echo(string: String, context: Context): Result {
        if (haveBeenHereTwice()) {
            context.state = LowerCaseState()
            return Result(string.toUpperCase(), State(LowerCaseState(), 1))
        }
        return Result(string.toUpperCase(), State(UpperCaseState(), 1))
    }

    private fun haveBeenHereTwice() = ++count > 1
}
