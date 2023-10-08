class HamiltonianCycle(private val graph: Array<IntArray>) {
    private val numVertices: Int = graph.size
    private val path: IntArray = IntArray(numVertices)

    private fun isSafe(v: Int, pos: Int, path: IntArray): Boolean {
        // Check if the vertex can be added to the path
        if (graph[path[pos - 1]][v] == 0) {
            return false
        }

        // Check if the vertex is not already in the path
        for (i in 0 until pos) {
            if (path[i] == v) {
                return false
            }
        }

        return true
    }

    private fun hamiltonianCycleUtil(pathPos: Int): Boolean {
        if (pathPos == numVertices) {
            // If all vertices are included in the path, check if it forms a cycle
            if (graph[path[pathPos - 1]][path[0]] == 1) {
                return true // Hamiltonian Cycle found
            }
            return false
        }

        for (v in 1 until numVertices) {
            if (isSafe(v, pathPos, path)) {
                path[pathPos] = v

                if (hamiltonianCycleUtil(pathPos + 1)) {
                    return true
                }

                path[pathPos] = -1 // Backtrack
            }
        }

        return false
    }

    fun findHamiltonianCycle(): Boolean {
        // Initialize the path array with -1
        for (i in 0 until numVertices) {
            path[i] = -1
        }

        // Start from the first vertex (0)
        path[0] = 0

        if (!hamiltonianCycleUtil(1)) {
            println("No Hamiltonian Cycle exists")
            return false
        }

        printHamiltonianCycle()
        return true
    }

    private fun printHamiltonianCycle() {
        println("Hamiltonian Cycle:")
        for (i in 0 until numVertices) {
            print("${path[i]} -> ")
        }
        println("${path[0]}") // Print the first vertex to complete the cycle
    }
}

// main function, entry point of the program
fun main() {
    val graph = arrayOf(
        intArrayOf(0, 1, 0, 1, 0),
        intArrayOf(1, 0, 1, 1, 1),
        intArrayOf(0, 1, 0, 0, 1),
        intArrayOf(1, 1, 0, 0, 1),
        intArrayOf(0, 1, 1, 1, 0)
    )

    val hamiltonianCycle = HamiltonianCycle(graph)
    hamiltonianCycle.findHamiltonianCycle()
}
