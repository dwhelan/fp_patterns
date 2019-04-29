package fp2

data class Result(val string: String, val state: State) {}

data class State(val name: StateName, val data: Int = 0)

enum class StateName { LOWER_CASE, UPPER_CASE }
val LOWER_CASE = StateName.LOWER_CASE
val UPPER_CASE = StateName.UPPER_CASE

val actions = mapOf<StateName, (String) -> String> (
    LOWER_CASE to { string -> string.toLowerCase() },
    UPPER_CASE to { string -> string.toUpperCase() }
)

val transitions = mapOf<StateName, (State) -> State> (
    LOWER_CASE to { _ -> State(UPPER_CASE) },
    UPPER_CASE to { state ->
        if (state.data == 1)
            State(LOWER_CASE)
        else
            State(UPPER_CASE, state.data + 1)
    }
)

fun echo(string: String, state: State = State(LOWER_CASE)) =
    Result(act(string, state), next(state))

fun act(string: String, state: State) =
    actions[state.name]!!.invoke(string)

fun next(state: State) =
    transitions[state.name]!!.invoke(state)


//data class State(val processor: Processor = LowerCase(), val count: Int = 0) {}
//interface Processor {
//    fun echo(string: String, state: State): Result
//}
//
//class LowerCase : Processor {
//    override fun echo(string: String, state: State) =
//        Result(string.toLowerCase(), State(UpperCase()))
//}
//
//class UpperCase : Processor {
//    override fun echo(string: String, state: State) =
//        Result(string.toUpperCase(), transitions(state))
//
//    private fun transitions(state: State) : State  {
//        if (isSecondTime(state)) {
//            return State(LowerCase())
//        } else {
//            return State(UpperCase(), state.count + 1)
//        }
//    }
//
//    private fun isSecondTime(state: State) = state.count > 0
//}
