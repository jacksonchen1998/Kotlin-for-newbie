// Job Sequencing Problem in Kotlin

import java.util.Arrays
import java.util.Comparator

class Job(var id: Char, var deadline: Int, var profit: Int)

class JobSequencing {
    fun printJobScheduling(arr: Array<Job>, t: Int) {
        // length of array
        val n = arr.size
        // Sort all jobs according to decreasing order of profit
        Arrays.sort(arr, Comparator.comparingInt { obj: Job -> obj.profit }.reversed())
        // To keep track of free time slots
        val result = IntArray(t)
        // To store result (Sequence of jobs)
        val job = BooleanArray(t)
        // Iterate through all given jobs
        var i = 0
        while (i < n) {
            // Find a free slot for this job (Note that we start
            // from the last possible slot)
            var j = Math.min(t - 1, arr[i].deadline - 1)
            while (j >= 0) {
                // Free slot found
                if (!job[j]) {
                    result[j] = i // Add this job to result
                    job[j] = true // Make this slot occupied
                    break
                }
                j--
            }
            i++
        }
        // Print the result
        for (k in 0 until t) if (job[k]) println(arr[result[k]].id)
    }
}

// main function
fun main(args: Array<String>) {
    val arr = arrayOf(
        Job('a', 2, 100),
        Job('b', 1, 19),
        Job('c', 2, 27),
        Job('d', 1, 25),
        Job('e', 3, 15)
    )
    val t = 3
    val js = JobSequencing()
    js.printJobScheduling(arr, t)
}