// Rod Cutting Problem in Kotlin
class RodCutting {
    fun cutRod(price: IntArray, n: Int): Int {
        val valArray = IntArray(n + 1)
        valArray[0] = 0
        for (i in 1..n) {
            var maxVal = Integer.MIN_VALUE
            for (j in 0 until i) {
                maxVal = Math.max(maxVal, price[j] + valArray[i - j - 1])
            }
            valArray[i] = maxVal
        }
        return valArray[n]
    }
}

// main function
fun main(args: Array<String>) {
    val arr = intArrayOf(1, 5, 8, 9, 10, 17, 17, 20)
    val size = arr.size
    val rc = RodCutting()
    println("Maximum Obtainable Value is ${rc.cutRod(arr, size)}")
}