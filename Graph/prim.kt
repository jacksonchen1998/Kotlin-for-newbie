// Prim's algorithm in Kotlin

import java.util.PriorityQueue

// Edge class
data class Edge(val from: Int, val to: Int, val weight: Int)

// Graph class
class Graph(val vertices: Int) {
    val nodes = IntArray(vertices)
    val edges = mutableListOf<Edge>()

    fun addEdge(from: Int, to: Int, weight: Int) {
        nodes[from] = from
        nodes[to] = to
        edges.add(Edge(from, to, weight))
    }
}

class Prim(val graph: Graph) {
    val mst = mutableListOf<Edge>()
    val visited = mutableSetOf<Int>()
    val pq = PriorityQueue<Edge>(graph.edges.size, compareBy { it.weight })

    fun run() {
        val start = graph.nodes[0]
        visited.add(start)
        addEdges(start)
        while (pq.isNotEmpty()) {
            val edge = pq.poll()
            if (edge.to !in visited) {
                mst.add(edge)
                visited.add(edge.to)
                addEdges(edge.to)
            }
        }
    }

    fun addEdges(node: Int) {
        for (edge in graph.edges) {
            if (edge.from == node && edge.to !in visited) {
                pq.add(edge)
            }
        }
    }
}

// main function
fun main(args: Array<String>) {
    val graph = Graph(5)
    graph.addEdge(0, 1, 2)
    graph.addEdge(0, 3, 6)
    graph.addEdge(1, 2, 3)
    graph.addEdge(1, 3, 8)
    graph.addEdge(1, 4, 5)
    graph.addEdge(2, 4, 7)
    graph.addEdge(3, 4, 9)
    val prim = Prim(graph)
    prim.run()
    println("Minimum Spanning Tree:")
    for (edge in prim.mst) {
        println("${edge.from} -> ${edge.to} = ${edge.weight}")
    }
}