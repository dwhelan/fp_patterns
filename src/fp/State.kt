package fp

data class Result(val string: String, val state: State) {}

data class State(val name: EchoState, val data: Int = 0) {}

enum class EchoState { LOWER_CASE, UPPER_CASE }
fun lowerCase() = EchoState.LOWER_CASE
fun upperCase() = EchoState.UPPER_CASE

val doers = mapOf<EchoState, (String, State) -> Result> (
    lowerCase() to ::doLowerCase,
    upperCase() to ::doUpperCase
)

fun echo(string: String, state: State = State(lowerCase())) =
    doers[state.name]!!.invoke(string, state)

fun doLowerCase(string: String, state: State) = Result(
    string.toLowerCase(),
    State(upperCase())
)

fun doUpperCase(string: String, state: State) = Result(
    string.toUpperCase(),
    if (state.data > 0)
        State(lowerCase())
    else
        State(upperCase(), state.data + 1)
)


// Replace polymorphism with map of functions

//}

//interface EchoState {
//    fun echo(string: String, state: State): Result
//}
//
//class LowerCase : EchoState {
//    override fun echo(string: String, state: State) =
//        Result(string.toLowerCase(), State(UpperCase()))
//}
//
//class UpperCase : EchoState {
//    override fun echo(string: String, state: State) =
//        Result(
//            string.toUpperCase(),
//            if (state.data > 0) {
//                State(LowerCase())
//            } else {
//                State(UpperCase(), state.data + 1)
//            }
//        )
//}
