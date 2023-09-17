// Quick sort algorithm 
class QuickSort {
    fun sort(arr: IntArray, low: Int, high: Int) {
        if (low < high) {
            val pi = partition(arr, low, high)
            sort(arr, low, pi - 1)
            sort(arr, pi + 1, high)
        }
    }

    fun partition(arr: IntArray, low: Int, high: Int): Int {
        val pivot = arr[high]
        var i = low - 1
        for (j in low until high) {
            if (arr[j] < pivot) {
                i++
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
        val temp = arr[i + 1]
        arr[i + 1] = arr[high]
        arr[high] = temp
        return i + 1
    }
}

// main function
fun main(args: Array<String>) {
    val arr = intArrayOf(-8, -8, -87, 12, 0, 34, 64, 90, 12)
    val quickSort = QuickSort()
    quickSort.sort(arr, 0, arr.size - 1)
    println("Sorted array")
    for (i in arr.indices) {
        print(arr[i].toString() + " ")
    }
}