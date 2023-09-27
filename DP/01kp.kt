// 0-1 Knapsack Problem in Kotlin

// library imports
import java.util.Arrays

class Knapsack {
    fun knapSack(W: Int, wt: IntArray, value: IntArray, n: Int): Int {
        val K = Array(n + 1) { IntArray(W + 1) }
        for (i in 0..n) {
            for (w in 0..W) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0
                } else if (wt[i - 1] <= w) {
                    K[i][w] = Math.max(value[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w])
                } else {
                    K[i][w] = K[i - 1][w]
                }
            }
        }
        return K[n][W]
    }
}

// main function
fun main(args: Array<String>) {
    val value = intArrayOf(60, 100, 120)
    val wt = intArrayOf(10, 20, 30)
    val W = 50
    val n = value.size
    val knapsack = Knapsack()
    println("Maximum value that can be obtained is ${knapsack.knapSack(W, wt, value, n)}")
}