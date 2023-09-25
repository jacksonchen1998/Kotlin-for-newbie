// Kruskal's algorithm in Kotlin

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

// Union-Find class
class UnionFind(val size: Int) {
    val parent = IntArray(size)
    val rank = IntArray(size)

    init {
        for (i in 0 until size) {
            parent[i] = i
        }
    }

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX == rootY) return
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX
        } else {
            parent[rootY] = rootX
            rank[rootX]++
        }
    }

    fun connected(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }
}

class Kruskal(val graph: Graph) {
    val mst = mutableListOf<Edge>()
    val uf = UnionFind(graph.vertices)
    val pq = PriorityQueue<Edge>(graph.edges.size, compareBy { it.weight })

    fun run() {
        for (edge in graph.edges) {
            pq.add(edge)
        }
        while (pq.isNotEmpty()) {
            val edge = pq.poll()
            if (!uf.connected(edge.from, edge.to)) {
                uf.union(edge.from, edge.to)
                mst.add(edge)
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
    val kruskal = Kruskal(graph)
    kruskal.run()
    println("Minimum Spanning Tree:")
    for (edge in kruskal.mst) {
        println("${edge.from} -> ${edge.to} = ${edge.weight}")
    }
}