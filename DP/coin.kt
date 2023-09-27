// Coin Change Problem in Kotlin

import java.util.Arrays

class CoinChange {
    fun count(S: IntArray, m: Int, n: Int): Int {
        val table = IntArray(n + 1)
        Arrays.fill(table, 0)
        table[0] = 1
        for (i in 0 until m) {
            for (j in S[i]..n) {
                table[j] += table[j - S[i]]
            }
        }
        return table[n]
    }
}

// main function
fun main(args: Array<String>) {
    val S = intArrayOf(1, 2, 3)
    val m = S.size
    val n = 4
    val cc = CoinChange()
    println(cc.count(S, m, n))
}