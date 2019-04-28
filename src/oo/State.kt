package oo

class Context {
    private var state: State = LowerCaseState()

    fun setState(newState: State) { state = newState }

    fun echo(string: String) = state.echo(string, this)
}

interface State {
    fun echo(string: String, context: Context): String
}

class LowerCaseState : State {
    override fun echo(string: String, context: Context): String {
        context.setState(UpperCaseState())
        return string.toLowerCase()
    }
}

class UpperCaseState : State {
    private var count = 0

    override fun echo(string: String, context: Context): String {
        if (haveBeenHereTwice()) { context.setState(LowerCaseState()) }
        return string.toUpperCase()
    }

    private fun haveBeenHereTwice() =  ++count > 1
}
