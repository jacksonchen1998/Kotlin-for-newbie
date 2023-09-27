// Matrix Chain Multiplication in Kotlin
class MatrixChainMultiplication {
    fun matrixChainOrder(p: IntArray, n: Int): Int {
        val m = Array(n) { IntArray(n) }
        var i: Int
        var j: Int
        var k: Int
        var L: Int
        var q: Int
        i = 1
        while (i < n) {
            m[i][i] = 0
            i++
        }
        L = 2
        while (L < n) {
            i = 1
            while (i < n - L + 1) {
                j = i + L - 1
                if (j == n) {
                    continue
                }
                m[i][j] = Integer.MAX_VALUE
                k = i
                while (k <= j - 1) {
                    q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j]
                    if (q < m[i][j]) {
                        m[i][j] = q
                    }
                    k++
                }
                i++
            }
            L++
        }
        return m[1][n - 1]
    }
}

// main function
fun main(args: Array<String>) {
    val arr = intArrayOf(1, 2, 3, 4)
    val size = arr.size
    val mcm = MatrixChainMultiplication()
    println("Minimum number of multiplications is ${mcm.matrixChainOrder(arr, size)}")
}