// N Queen Problem in Kotlin
class NQueen {
    private val N = 4 // board size
    private val board = Array(N) { IntArray(N) }

    private fun printSolution(board: Array<IntArray>) {
        for (i in 0 until N) {
            for (j in 0 until N)
                print(" " + board[i][j]
                        + " ")
            println()
        }
    }

    private fun isSafe(board: Array<IntArray>, row: Int, col: Int): Boolean {
        var i: Int
        var j: Int

        /* Check this row on left side */
        i = 0
        while (i < col) {
            if (board[row][i] == 1)
                return false
            i++
        }

        /* Check upper diagonal on left side */
        i = row
        j = col
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1)
                return false
            i--
            j--
        }

        /* Check lower diagonal on left side */
        i = row
        j = col
        while (j >= 0 && i < N) {
            if (board[i][j] == 1)
                return false
            i++
            j--
        }

        return true
    }

    private fun solveNQUtil(board: Array<IntArray>, col: Int): Boolean {
        if (col >= N)
            return true

        for (i in 0 until N) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1
                if (solveNQUtil(board, col + 1))
                    return true
                board[i][col] = 0 // BACKTRACK
            }
        }

        return false
    }

    fun solveNQ() {
        if (!solveNQUtil(board, 0)) {
            println("Solution does not exist")
            return
        }
        printSolution(board)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val Queen = NQueen()
            Queen.solveNQ()
        }
    }
}

// main function
fun main(args: Array<String>) {
    val Queen = NQueen()
    Queen.solveNQ()
}