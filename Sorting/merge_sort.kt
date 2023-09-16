// merge sort algorithm
class MergeSort {
    fun merge(arr: IntArray, l: Int, m: Int, r: Int) {
        // Find sizes of two subarrays to be merged
        val n1 = m - l + 1
        val n2 = r - m

        /* Create temp arrays */
        val L = IntArray(n1)
        val R = IntArray(n2)

        /*Copy data to temp arrays*/
        for (i in 0 until n1) L[i] = arr[l + i]
        for (j in 0 until n2) R[j] = arr[m + 1 + j]

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        var i = 0
        var j = 0

        // Initial index of merged subarry array
        var k = l
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i]
                i++
            } else {
                arr[k] = R[j]
                j++
            }
            k++
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i]
            i++
            k++
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j]
            j++
            k++
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    fun sort(arr: IntArray, l: Int, r: Int) {
        if (l < r) {
            // Find the middle point
            val m = (l + r) / 2

            // Sort first and second halves
            sort(arr, l, m)
            sort(arr, m + 1, r)

            // Merge the sorted halves
            merge(arr, l, m, r)
        }
    }
}

// main function
fun main(args: Array<String>) {
    val arr = intArrayOf(-57, 12, -8, 0, 34, 64, 90, 12)
    val mergeSort = MergeSort()
    mergeSort.sort(arr, 0, arr.size - 1)
    println("Sorted array")
    for (i in arr.indices) {
        print(arr[i].toString() + " ")
    }
}