// Bubble sort algorithm

class BubbleSort {
    fun sort(arr: IntArray) {
        val n = arr.size
        for (i in 0 until n - 1) {
            for (j in 0 until n - i - 1) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                }
            }
        }
    }
}

/*
Sorted array
11 12 22 25 34 64 90
*/

// main function
fun main(args: Array<String>) {
    val arr = intArrayOf(64, 34, 25, 12, 22, 11, 90)
    val bubbleSort = BubbleSort()
    bubbleSort.sort(arr)
    println("Sorted array")
    for (i in arr.indices) {
        print(arr[i].toString() + " ")
    }
}
