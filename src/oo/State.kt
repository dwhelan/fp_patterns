package oo

class Context {
    private var state: State = LowerCase()

    internal fun setState(state: State) { this.state = state }

    fun echo(string: String) = state.echo(string, this)
}

interface State {
    fun echo(string: String, context: Context): String
}

class LowerCase : State {
    override fun echo(string: String, context: Context): String {
        val result = string.toLowerCase()
        context.setState(UpperCase())
        return result
    }
}

class UpperCase : State {
    private var data = 0

    override fun echo(string: String, context: Context): String {
        val result = string.toUpperCase()
        if (data > 0)
            context.setState(LowerCase())
        else
            data++
        return result
    }
}
