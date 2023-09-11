fun main() {
    // create an array
    val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5)
    for (i in numbers.indices) {
        println(numbers[i])
    }

    println("------------------")

    // create an array using factory functions
    val numbers2 = IntArray(5)
    // for (i in numbers2.indices) {
    //     numbers2[i] = i + 1
    // }
    for (i in numbers2.indices) {
        println(numbers2[i])
    }

    // size of an array
    println("Size of array: ${numbers.size}")
    // is empty
    println("Is empty: ${numbers.isEmpty()}")
    // contains
    println("Contains 3: ${numbers.contains(3)}")
}