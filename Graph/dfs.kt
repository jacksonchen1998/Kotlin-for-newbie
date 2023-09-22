// Depth-First Search

import java.util.LinkedList

// Graph class
class Graph(val vertices: Int) {
    val adjacencyListArray = Array(vertices) { LinkedList<Int>() }
    fun addEdge(src: Int, dest: Int) {
        adjacencyListArray[src].add(dest)
    }
}

class DFS {
    fun dfs(graph: Graph, start: Int) {
        val visited = BooleanArray(graph.vertices)
        dfsUtil(graph, start, visited)
    }

    private fun dfsUtil(graph: Graph, current: Int, visited: BooleanArray) {
        visited[current] = true
        print("$current ")
        val edges = graph.adjacencyListArray[current]
        for (edge in edges) {
            if (!visited[edge]) {
                dfsUtil(graph, edge, visited)
            }
        }
    }
}

// GRAPH
// 0-----1
// |    /|
// |  /  |
// |/    |
// 2-----3

// main function
fun main(args: Array<String>) {
    val graph = Graph(4)
    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 2)
    graph.addEdge(2, 0)
    graph.addEdge(2, 3)
    println("Following is Breadth First Traversal " + "(starting from vertex 2)")
    val dfs = DFS()
    dfs.dfs(graph, 2)
}