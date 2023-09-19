// Counting sort
class CountingSort {
    fun sort(arr: IntArray) {
        val n = arr.size
        val output = IntArray(n)
        val count = IntArray(256)
        for (i in 0..255) count[i] = 0
        for (i in 0 until n) ++count[arr[i]]
        for (i in 1..255) count[i] += count[i - 1]
        for (i in n - 1 downTo 0) {
            output[count[arr[i]] - 1] = arr[i]
            --count[arr[i]]
        }
        for (i in 0 until n) arr[i] = output[i]
    }

    fun printArray(arr: IntArray, size: Int) {
        for (i in 0 until size) print(arr[i].toString() + " ")
        println()
    }
}

// main function
fun main(args: Array<String>) {
    val arr = intArrayOf(5, 0, 1, 88, 9, 112, 58)
    val n = arr.size
    val ob = CountingSort()
    ob.sort(arr)
    println("sorted array")
    ob.printArray(arr, n)
}