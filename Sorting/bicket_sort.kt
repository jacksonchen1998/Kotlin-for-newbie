fun insertionSort(arr: ArrayList<Int>) {
    val n = arr.size
    for (j in 1 until n) {
        val key = arr[j]
        var i = j - 1
        while (i >= 0 && arr[i] > key) {
            arr[i + 1] = arr[i]
            i--
        }
        arr[i + 1] = key
    }
}

fun bucketSort(arr: Array<Int>) {
    val n = arr.size
    var maxVal = Int.MIN_VALUE
    var minVal = Int.MAX_VALUE

    for (i in 0 until n) {
        if (arr[i] > maxVal) {
            maxVal = arr[i]
        }
        if (arr[i] < minVal) {
            minVal = arr[i]
        }
    }

    val bucketCount = maxVal - minVal + 1
    val buckets = Array(bucketCount) { ArrayList<Int>() }

    for (i in 0 until n) {
        val index = arr[i] - minVal
        buckets[index].add(arr[i])
    }

    var index = 0
    for (bucket in buckets) {
        if (bucket.isNotEmpty()) {
            insertionSort(bucket)
            for (num in bucket) {
                arr[index] = num
                index++
            }
        }
    }
}

fun main(args: Array<String>) {
    val A = arrayOf(12, 0, 34, 64, 90, 12)
    println("Before sorting:")
    for (i in A) {
        print("$i ")
    }
    println()
    bucketSort(A)
    println("\nAfter sorting:")
    for (i in A) {
        print("$i ")
    }
}
