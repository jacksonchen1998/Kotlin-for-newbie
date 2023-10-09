fun isSubsetSum(nums: IntArray, target: Int): Boolean {
    return isSubsetSumHelper(nums, target, 0)
}

fun isSubsetSumHelper(nums: IntArray, target: Int, currentIndex: Int): Boolean {
    // If the target becomes 0, we have found a valid subset
    if (target == 0) {
        return true
    }

    // If we have exhausted the array or target becomes negative, no valid subset can be found
    if (currentIndex >= nums.size || target < 0) {
        return false
    }

    // Include the current element in the subset and check recursively
    val includeResult = isSubsetSumHelper(nums, target - nums[currentIndex], currentIndex + 1)

    // Exclude the current element from the subset and check recursively
    val excludeResult = isSubsetSumHelper(nums, target, currentIndex + 1)

    // Return true if either of the above recursive calls returns true
    return includeResult || excludeResult
}

fun main() {
    val nums = intArrayOf(3, 34, 4, 12, 5, 2)
    val target = 9
    val result = isSubsetSum(nums, target)

    if (result) {
        println("Subset with sum $target exists.")
    } else {
        println("No subset with sum $target exists.")
    }
}
