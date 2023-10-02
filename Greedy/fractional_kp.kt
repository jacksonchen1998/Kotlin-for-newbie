// Fractional Knapsack Problem in Kotlin

data class Item(val weight: Double, val value: Double)

fun fractionalKnapsack(items: List<Item>, capacity: Double): Double {
    // Sort items by value density (value/weight) in descending order
    val sortedItems = items.sortedByDescending { it.value / it.weight }
    
    var currentWeight = 0.0
    var totalValue = 0.0
    
    for (item in sortedItems) {
        if (currentWeight + item.weight <= capacity) {
            // Add the whole item to the knapsack
            currentWeight += item.weight
            totalValue += item.value
        } else {
            // Add a fraction of the item to fill the remaining capacity
            val remainingCapacity = capacity - currentWeight
            val fraction = remainingCapacity / item.weight
            totalValue += fraction * item.value
            break
        }
    }
    
    return totalValue
}

fun main() {
    val items = listOf(
        Item(10.0, 60.0),
        Item(20.0, 100.0),
        Item(30.0, 120.0)
    )
    val capacity = 50.0
    
    val maxValue = fractionalKnapsack(items, capacity)
    println("Maximum value in the knapsack: $maxValue")
}
