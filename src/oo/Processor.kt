package oo

class Context {
    internal var state: Processor = LowerCase()

    fun echo(string: String) = state.echo(string, this)
}

interface Processor {
    fun echo(string: String, context: Context): String
}

class LowerCase : Processor {
    override fun echo(string: String, context: Context): String {
        context.state = UpperCase()
        return string.toLowerCase()
    }
}

class UpperCase : Processor {
    private var count = 0

    override fun echo(string: String, context: Context): String {
        if (haveBeenHereTwice()) { context.state = LowerCase() }
        return string.toUpperCase()
    }

    private fun haveBeenHereTwice() =  ++count > 1
}
