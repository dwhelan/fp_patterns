package fp2

data class Result(val string: String, val state: State) {}

data class State(val name: StateName, val data: Int = 0)

fun echo(string: String, state: State = State(LOWER_CASE)) =
    Result(act(string, state), next(state))

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
        if (state.data > 0)
            State(LOWER_CASE)
        else
            State(UPPER_CASE, state.data + 1)
    }
)

fun act(string: String, state: State) =
    actions[state.name]!!.invoke(string)

fun next(state: State) =
    transitions[state.name]!!.invoke(state)
