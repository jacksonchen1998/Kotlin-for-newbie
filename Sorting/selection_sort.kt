// Selection sort

class SelectionSort {
    fun sort(arr: IntArray) {
        val n = arr.size
        for (i in 0 until n - 1) {
            var min_idx = i
            for (j in i + 1 until n) if (arr[j] < arr[min_idx]) min_idx = j
            // Swap the found minimum element with the first
            // element
            val temp = arr[min_idx]
            arr[min_idx] = arr[i]
            arr[i] = temp
        }
    }
}

/*
Sorted array
-8 7 12 22 25 34 64 90
*/

// main function
fun main(args: Array<String>) {
    val arr = intArrayOf(12, 7, -8, 22, 25, 34, 64, 90)
    val selectionSort = SelectionSort()
    selectionSort.sort(arr)
    println("Sorted array")
    for (i in arr.indices) {
        print(arr[i].toString() + " ")
    }
}