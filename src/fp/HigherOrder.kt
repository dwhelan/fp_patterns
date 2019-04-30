package fp

typealias Operation = (Int) -> Int

val inc:    Operation = { x -> x + 1 }
val square: Operation = { x -> x * x }

val math: (Operation, Int) -> Int = { f, x -> f(x) }

fun main() {
    math(inc, 3)    // 4
    math(square, 4) // 16
}
