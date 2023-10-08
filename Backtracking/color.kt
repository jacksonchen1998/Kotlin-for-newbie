class Graph(private val vertices: Int) {
    private val adjacencyMatrix = Array(vertices) { BooleanArray(vertices) }
    private val colors = IntArray(vertices)

    fun addEdge(v: Int, w: Int) {
        adjacencyMatrix[v][w] = true
        adjacencyMatrix[w][v] = true
    }

    fun graphColoring(): Boolean {
        return graphColoringUtil(0)
    }

    private fun graphColoringUtil(vertex: Int): Boolean {
        if (vertex == vertices) {
            return true
        }
        for (color in 1..vertices) {
            if (isSafe(vertex, color)) {
                colors[vertex] = color
                if (graphColoringUtil(vertex + 1)) {
                    return true
                }
                colors[vertex] = 0
            }
        }
        return false
    }

    private fun isSafe(vertex: Int, color: Int): Boolean {
        for (i in 0 until vertices) {
            if (adjacencyMatrix[vertex][i] && colors[i] == color) {
                return false
            }
        }
        return true
    }

    fun printSolution() {
        for (i in 0 until vertices) {
            println("Vertex $i: Color ${colors[i]}")
        }
    }
}

fun main() {
    val g = Graph(4)
    g.addEdge(0, 1)
    g.addEdge(0, 2)
    g.addEdge(1, 2)
    g.addEdge(1, 3)

    if (g.graphColoring()) {
        println("Solution exists:")
        g.printSolution()
    } else {
        println("No solution exists")
    }
}
