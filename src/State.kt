
fun echo(string: String, context: Context = Context()) =
    Result(context.state.echo(string, context), context)

data class Result(val string: String, val state: Context) {}

data class Context(var state: Echo = LowerCase()) {}

interface Echo {
    fun echo(string: String, context: Context): String
}

class LowerCase : Echo {
    override fun echo(string: String, context: Context): String {
        context.state = UpperCase()
        return string.toLowerCase()
    }
}

class UpperCase : Echo {
    private var count = 0

    override fun echo(string: String, context: Context): String {
        count++
        if (isSecondTime())
            context.state = LowerCase()
        return string.toUpperCase()
    }

    private fun isSecondTime() = 1 < count
}
