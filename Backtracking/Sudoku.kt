// Sudoku in Kotlin

fun solveSudoku(board: Array<CharArray>): Boolean {
    for (row in 0 until 9) {
        for (col in 0 until 9) {
            if (board[row][col] == '.') {
                for (num in '1'..'9') {
                    if (isValid(board, row, col, num)) {
                        board[row][col] = num
                        if (solveSudoku(board)) {
                            return true
                        }
                        board[row][col] = '.' // Undo the current placement and try the next number
                    }
                }
                return false // No valid number found, backtrack
            }
        }
    }
    return true // Sudoku solved
}

fun isValid(board: Array<CharArray>, row: Int, col: Int, num: Char): Boolean {
    val subgridRow = 3 * (row / 3)
    val subgridCol = 3 * (col / 3)
    
    // Check row and column
    for (i in 0 until 9) {
        if (board[row][i] == num || board[i][col] == num) {
            return false
        }
    }
    
    // Check subgrid
    for (i in subgridRow until subgridRow + 3) {
        for (j in subgridCol until subgridCol + 3) {
            if (board[i][j] == num) {
                return false
            }
        }
    }
    
    return true
}

fun main() {
    val sudokuBoard = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    // Print the unsolved sudoku board
    println("Unsolved sudoku:")
    for (row in sudokuBoard) {
        println(row.joinToString(" "))
    }

    if (solveSudoku(sudokuBoard)) {
        println("Sudoku solved:")
        for (row in sudokuBoard) {
            println(row.joinToString(" "))
        }
    } else {
        println("No solution exists.")
    }
}
