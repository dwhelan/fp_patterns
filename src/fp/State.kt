package fp

//typealias State = (String) -> Pair<String, (String) -> String>
//typealias Result = Pair<String, State>
//
//val upperCaseState:
//val lowerCase: (String) -> Result = {
//    string -> Pair(string.toLowerCase(), )
//}
//typealias StateName = Any
//typealias Processor = Pair<String, Any>
//typealias Foo = (Processor) -> Processor
//
//val upperCase: (Processor) -> Processor = { result -> Pair(result.first.toUpperCase(), result.second) }
//val lowerCase: (Processor) -> Processor = { result -> Pair(result.first.toLowerCase(), upperCase) }
//
//val echo2: (Processor) -> Processor = {result -> (result.second as Foo)(result) }
//val echo: (String) -> Processor = { string -> lowerCase(Pair(string, lowerCase)) }
//val lowerCase : Foo = { result -> result }
//
//val echo: (String) -> Processor = {
//    string  ->  lowerCase(Pair(string, lowerCase))
//}

//enum class StateName { LOWER, UPPER }
//
//typealias State = Pair<StateName, Int>
//typealias Result = Pair<String, State>
//typealias Processor = (Result) -> Result
//
//val lowerCase: (Result) -> Result = {
//    result -> Pair(string(result).toLowerCase(), Pair(StateName.UPPER, 0))
//}
//
//val upperCase: Processor = {
//    result ->
//        val string = string(result).toUpperCase()
//        val count = count(result)
//
//        if (count > 1)
//            Pair(string, Pair(StateName.LOWER, 0))
//        else
//            Pair(string, Pair(StateName.UPPER, count + 1))
//}
//
//val map : Map<StateName, Processor> = mapOf(StateName.LOWER to lowerCase, StateName.UPPER to upperCase)
//
//val echo: (String) -> Result = {
//    string -> lcase(Pair(string, initialState))
//}
//val echo2: (Result) -> Result = {
//    string -> lcase(Pair(string, Pair(StateName.UPPER, 0)))
//}
//
//
//val lcase: (Result) -> Result = {
//    result -> Pair(string(result).toLowerCase(), Pair(StateName.UPPER, 0))
//}
//
//val initialState: State = Pair(StateName.UPPER, 0)
//val string: (Result) -> String = { it.first }
//val state: (Result) -> State = { it.second }
//val count: (Result) -> Int = { state(it).second }
//
//
//val stateMap: Map<StateName, (Pair<String, StateName>)> = mapOf( StateName.LOWER to lowerCase)
//interface Function<T> : (Pair<String, T>) -> Pair<String, T>

//interface Processor : Function<Processor>
//typealias Result = Pair<String, Processor>
//
////val lowerCase: (Processor) -> Processor = { result -> Pair(result.toLowerCase(), upperCase) }
//class LowerCase : Processor {
//    override fun invoke(p1: Pair<String, Processor>): Pair<String, Processor> = Pair(p1.first.toLowerCase(), p1.second)
//}
//
//val lowerCase: (Pair<String, Processor>) -> Pair<String, Processor> = {
//    result -> Pair(result.first.toLowerCase())
//}
//    result -> Pair(result.first.toLowerCase(), result.second)


//val upperCase: (Result) -> Result = {
//    result -> Pair(result.first.toLowerCase(), lowerCase)
//}

//val upperCase: (Result) -> Result = {
//    result -> Pair(result.first.toUpperCase(), lowerCase)
//}
//
//class Step2 : Processor {
//    override fun invoke(p1: Processor): Processor = Step1()
//}
