package oo

class Context {
    private var processor: Processor = LowerCase()

    internal fun setProcessor(processor: Processor) { this.processor = processor }

    fun echo(string: String) = processor.echo(string, this)
}

interface Processor {
    fun echo(string: String, context: Context): String
}

class LowerCase : Processor {
    override fun echo(string: String, context: Context): String {
        context.setProcessor(UpperCase())
        return string.toLowerCase()
    }
}

class UpperCase : Processor {
    private var count = 0

    override fun echo(string: String, context: Context): String {
        if (isSecondTime()) {
            context.setProcessor(LowerCase())
        } else {
            count++
        }
        return string.toUpperCase()
    }

    private fun isSecondTime() = count > 0
}
