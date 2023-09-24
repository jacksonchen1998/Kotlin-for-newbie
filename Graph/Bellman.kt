// Bellman Ford Algorithm in Kotlin

class BellmanFord {

    fun bellmanFord(graph: Array<IntArray>, V: Int, E: Int, src: Int) {
        // Initialize distance of all vertices as infinite.
        val dis = IntArray(V)
        for (i in 0 until V) dis[i] = Int.MAX_VALUE

        // initialize distance of source as 0
        dis[src] = 0

        // Relax all edges |V| - 1 times. A simple shortest
        // path from src to any other vertex can have at-most |V| - 1 edges
        for (i in 0 until V - 1) {
            for (j in 0 until E) {
                if (dis[graph[j][0]] != Int.MAX_VALUE && dis[graph[j][0]] + graph[j][2] < dis[graph[j][1]])
                    dis[graph[j][1]] = dis[graph[j][0]] + graph[j][2]
            }
        }

        // check for negative-weight cycles.
        for (i in 0 until E) {
            val x = graph[i][0]
            val y = graph[i][1]
            val weight = graph[i][2]
            if (dis[x] != Int.MAX_VALUE && dis[x] + weight < dis[y])
                println("Graph contains negative weight cycle")
        }

        println("Vertex Distance from Source")
        for (i in 0 until V) println("$i\t\t${dis[i]}")
    }
}

// main function
fun main(args: Array<String>) {
    val V = 5 // Number of vertices in graph
    val E = 8 // Number of edges in graph

    // Every edge has three values (u, v, w) where
    // the edge is from vertex u to v. And weight
    // of the edge is w.
    val graph = arrayOf(
        intArrayOf(0, 1, -1),
        intArrayOf(0, 2, 4),
        intArrayOf(1, 2, 3),
        intArrayOf(1, 3, 2),
        intArrayOf(1, 4, 2),
        intArrayOf(3, 2, 5),
        intArrayOf(3, 1, 1),
        intArrayOf(4, 3, -3)
    )

    val bellmanFord = BellmanFord()
    bellmanFord.bellmanFord(graph, V, E, 0)
}