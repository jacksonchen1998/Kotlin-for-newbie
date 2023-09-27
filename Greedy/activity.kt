// Activity Selection Problem in Kotlin
class ActivitySelection {
    fun printMaxActivities(s: IntArray, f: IntArray, n: Int) {
        var i: Int
        var j: Int
        println("Following activities are selected")
        i = 0
        println(i)
        j = 1
        while (j < n) {
            if (s[j] >= f[i]) {
                println(j)
                i = j
            }
            j++
        }
    }
}

// main function
fun main(args: Array<String>) {
    val s = intArrayOf(1, 3, 0, 5, 8, 5)
    val f = intArrayOf(2, 4, 6, 7, 9, 9)
    val n = s.size
    val asp = ActivitySelection()
    asp.printMaxActivities(s, f, n)
}