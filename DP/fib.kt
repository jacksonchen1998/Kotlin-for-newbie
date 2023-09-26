// Fibonacci Sequence
class Fibonacci {
    fun fib(n: Int): Int {
        if (n <= 1) return n
        return fib(n - 1) + fib(n - 2)
    }
}

// main function
fun main(args: Array<String>) {
    val fib = Fibonacci()
    println("Fibonacci(5) = ${fib.fib(5)}")
    println("Fibonacci(10) = ${fib.fib(10)}")
    println("Fibonacci(20) = ${fib.fib(20)}")
}