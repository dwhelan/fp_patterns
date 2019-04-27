package oo

internal interface State {
    fun echo(context: StateContext, string: String): String
}

internal class StateContext {
    private var state: State = LowerCaseState()

    fun setState(newState: State) { state = newState }

    fun writeName(name: String) = state.echo(this, name)
}

internal class LowerCaseState : State {
    override fun echo(context: StateContext, string: String): String {
        context.setState(UpperCaseState())
        return string.toLowerCase()
    }
}

internal class UpperCaseState : State {
    private var count = 0

    override fun echo(context: StateContext, string: String): String {
        if (haveBeenHereTwice()) { context.setState(LowerCaseState()) }
        return string.toUpperCase()
    }

    private fun haveBeenHereTwice() =  ++count > 1
}
