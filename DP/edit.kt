// Edit Distance Problem in Kotlin
class EditDistance {
    fun editDistDP(str1: String, str2: String, m: Int, n: Int): Int {
        val dp = Array(m + 1) { IntArray(n + 1) }
        for (i in 0..m) {
            for (j in 0..n) {
                if (i == 0) {
                    dp[i][j] = j
                } else if (j == 0) {
                    dp[i][j] = i
                } else if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1])
                }
            }
        }
        return dp[m][n]
    }
}

// main function
fun main(args: Array<String>) {
    val str1 = "sunday"
    val str2 = "saturday"
    val ed = EditDistance()
    println(ed.editDistDP(str1, str2, str1.length, str2.length))
}