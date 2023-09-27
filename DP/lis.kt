// Long Increasing Subsequence in Kotlin

import java.util.Arrays

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        var len = 0
        for (num in nums) {
            var i = Arrays.binarySearch(dp, 0, len, num)
            if (i < 0) i = -(i + 1)
            dp[i] = num
            if (i == len) len++
        }
        return len
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val nums = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
    val res: Int
    res = sol.lengthOfLIS(nums)
    println(res)
}