// Radix sort
class RadixSort {
    fun sort(arr: IntArray) {
        val n = arr.size
        val m = getMax(arr, n)
        for (exp in 1..m) countSort(arr, n, exp)
    }

    fun getMax(arr: IntArray, n: Int): Int {
        var mx = arr[0]
        for (i in 1 until n) if (arr[i] > mx) mx = arr[i]
        return mx
    }

    fun countSort(arr: IntArray, n: Int, exp: Int) {
        val output = IntArray(n)
        val count = IntArray(10)
        for (i in 0..9) count[i] = 0 // Initialize count array, count[i] will store total count of digit i in input array, range 0 to 9
        for (i in 0 until n) ++count[arr[i] / exp % 10]
        for (i in 1..9) count[i] += count[i - 1]
        for (i in n - 1 downTo 0) {
            output[count[arr[i] / exp % 10] - 1] = arr[i]
            --count[arr[i] / exp % 10]
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
    val ob = RadixSort()
    ob.sort(arr)
    println("sorted array")
    ob.printArray(arr, n)
}
