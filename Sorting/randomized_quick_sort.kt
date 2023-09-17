// Randomized Quick sort
class RandomizedQuickSort {
    // This Function helps in calculating
    // random numbers between low(inclusive)
    // and high(inclusive)
    fun randPartition(arr: IntArray, low: Int, high: Int): Int {
        val n = high - low + 1
        val pivot = (Math.random() % n).toInt()
        swap(arr, low + pivot, high)
        return partition(arr, low, high)
    }

    fun partition(arr: IntArray, low: Int, high: Int): Int {
        val pivot = arr[high]
        var i = low - 1
        for (j in low until high) {
            if (arr[j] <= pivot) {
                i++
                swap(arr, i, j)
            }
        }
        swap(arr, i + 1, high)
        return i + 1
    }

    fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    fun quickSort(arr: IntArray, low: Int, high: Int) {
        if (low < high) {
            val pi = randPartition(arr, low, high)
            quickSort(arr, low, pi - 1)
            quickSort(arr, pi + 1, high)
        }
    }

    fun printArray(arr: IntArray, size: Int) {
        for (i in 0 until size) print(arr[i].toString() + " ")
        println()
    }
}

// main function
fun main(args: Array<String>) {
    val arr = intArrayOf(-88, 58, -9, 112, 5, 0, 1)
    val n = arr.size
    val ob = RandomizedQuickSort()
    ob.quickSort(arr, 0, n - 1)
    println("sorted array")
    ob.printArray(arr, n)
}