// Breadth-First Search

import java.util.LinkedList

// Graph class
class Graph(val vertices: Int) {
    val adjacencyListArray = Array(vertices) { LinkedList<Int>() }
    fun addEdge(src: Int, dest: Int) {
        adjacencyListArray[src].add(dest)
    }
}

class BFS {
    fun bfs(graph: Graph, start: Int) {
        val visited = BooleanArray(graph.vertices)
        val queue = LinkedList<Int>()
        visited[start] = true
        queue.add(start)
        while (queue.size != 0) {
            val current = queue.poll()
            print("$current ")
            val edges = graph.adjacencyListArray[current]
            for (edge in edges) {
                if (!visited[edge]) {
                    visited[edge] = true
                    queue.add(edge)
                }
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
    val bfs = BFS()
    bfs.bfs(graph, 2)
}