fun isSubsetSum(nums: IntArray, target: Int): Boolean {
    val n = nums.size
    val dp = Array(n + 1) { BooleanArray(target + 1) }

    // Initialize the dp array
    for (i in 0..n) {
        dp[i][0] = true
    }

    for (i in 1..n) {
        for (j in 1..target) {
            dp[i][j] = dp[i - 1][j]
            if (j >= nums[i - 1]) {
                dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]]
            }
        }
    }
    
    return dp[n][target]
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
