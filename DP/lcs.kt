// Longest Common Subsequence in Kotlin

class LCS {
    fun lcs(X: String, Y: String, m: Int, n: Int): Int {
        val L = Array(m + 1) { IntArray(n + 1) }
        for (i in 0..m) {
            for (j in 0..n) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0
                } else if (X[i - 1] == Y[j - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1])
                }
            }
        }
        return L[m][n]
    }
}

// main function
fun main(args: Array<String>) {
    val X = "AGGTAB"
    val Y = "GXTXAYB"
    val m = X.length
    val n = Y.length
    val lcs = LCS()
    println("Length of LCS is ${lcs.lcs(X, Y, m, n)}")
}