package fp

enum class StateName { LOWER, UPPER }

data class State(internal val name: StateName, internal val count: Int) {
}

typealias Echo = Pair<String, State>

class Processor {
    fun echo(string: String) =
        lower_case(string)

    fun echo(result: Echo) =
        if (result.name == StateName.LOWER) {
            lower_case(result.string)
        } else {
            upper_case(result.string, result.count)
        }

    private fun lower_case(string: String) =
        result(string.toLowerCase(), StateName.UPPER, 0)

    private fun upper_case(string: String, count: Int) =
        when (count) {
            0    -> result(string.toUpperCase(), StateName.UPPER, count + 1)
            else -> result(string.toUpperCase(), StateName.LOWER, 0)
        }

    private fun result(string: String, name: StateName, count: Int) =
        Pair(string, State(name, count))

}

val Echo.string get() = this.first
val Echo.state get() = this.second
val Echo.name get() = this.state.name
val Echo.count get() = this.state.count
