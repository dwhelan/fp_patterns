class Context {
    internal var state: State = LowerCase()
    fun echo(string: String, context: Context) = state.echo(string, context)
}

interface State {
    fun echo(string: String, context: Context): String
}

class LowerCase : State {
    override fun echo(string: String, context: Context): String {
        context.state = UpperCase()
        return string.toLowerCase()
    }
}

class UpperCase : State {
    private var count = 0

    override fun echo(string: String, context: Context): String {
        count++
        if (isSecondTime())
            context.state = LowerCase()
        return string.toUpperCase()
    }

    private fun isSecondTime() = 1 < count
}
