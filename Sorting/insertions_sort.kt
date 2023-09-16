// insertion sort
class InsertionSort {
    fun sort(arr: IntArray) {
        val n = arr.size
        for (i in 1 until n) {
            val key = arr[i]
            var j = i - 1
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]
                j--
            }
            arr[j + 1] = key
        }
    }
}

// main function
fun main(args: Array<String>) {
    val arr = intArrayOf(-8, -8, -87, 12, 0, 34, 64, 90, 12)
    val insertionSort = InsertionSort()
    insertionSort.sort(arr)
    println("Sorted array")
    for (i in arr.indices) {
        print(arr[i].toString() + " ")
    }
}