// Heap sort
class HeapSort {
    fun sort(arr: IntArray) {
        val n = arr.size
        for (i in n / 2 - 1 downTo 0) {
            heapify(arr, n, i)
        }
        for (i in n - 1 downTo 0) {
            val temp = arr[0]
            arr[0] = arr[i]
            arr[i] = temp
            heapify(arr, i, 0)
        }
    }

    fun heapify(arr: IntArray, n: Int, i: Int) {
        var largest = i
        val l = 2 * i + 1
        val r = 2 * i + 2
        if (l < n && arr[l] > arr[largest]) {
            largest = l
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r
        }
        if (largest != i) {
            val swap = arr[i]
            arr[i] = arr[largest]
            arr[largest] = swap
            heapify(arr, n, largest)
        }
    }
}

// main function
fun main(args: Array<String>) {
    val arr = intArrayOf(-8, -8, -87, 12, 0, 34, 64, 90, 12)
    val heapSort = HeapSort()
    heapSort.sort(arr)
    println("Sorted array")
    for (i in arr.indices) {
        print(arr[i].toString() + " ")
    }
}