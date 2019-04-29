package fp2

data class Result(val string: String, val state: State) {}

data class State(val name: EchoState, val data: Int = 0)

fun echo(string: String, state: State = State(LOWER_CASE)) =
    Result(act(string, state), next(state))

enum class EchoState { LOWER_CASE, UPPER_CASE }
val LOWER_CASE = EchoState.LOWER_CASE
val UPPER_CASE = EchoState.UPPER_CASE

val actions = mapOf<EchoState, (String) -> String> (
    LOWER_CASE to { string -> string.toLowerCase() },
    UPPER_CASE to { string -> string.toUpperCase() }
)

val transitions = mapOf<EchoState, (State) -> State> (
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
