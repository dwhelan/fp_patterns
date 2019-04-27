package oo

interface State {
    fun echo(string: String, context: StateContext): String
}

class StateContext {
    private var state: State = LowerCaseState()

    fun setState(newState: State) { state = newState }

    fun echo(name: String) = state.echo(name, this)
}

class LowerCaseState : State {
    override fun echo(string: String, context: StateContext): String {
        context.setState(UpperCaseState())
        return string.toLowerCase()
    }
}

class UpperCaseState : State {
    private var count = 0

    override fun echo(string: String, context: StateContext): String {
        if (haveBeenHereTwice()) { context.setState(LowerCaseState()) }
        return string.toUpperCase()
    }

    private fun haveBeenHereTwice() =  ++count > 1
}
