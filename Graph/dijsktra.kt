// Dijstra algorithm in Kotlin
class Dijkstra {
    private val graph: Array<IntArray>
    private val n: Int
    private val dist: IntArray
    private val visited: BooleanArray

    constructor(graph: Array<IntArray>, n: Int) {
        this.graph = graph
        this.n = n
        dist = IntArray(n)
        visited = BooleanArray(n)
    }

    fun dijkstra(start: Int) {
        for (i in 0 until n) {
            dist[i] = Int.MAX_VALUE
            visited[i] = false
        }
        dist[start] = 0
        for (i in 0 until n - 1) {
            val u = minDistance(dist, visited)
            visited[u] = true
            for (v in 0 until n) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Int.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v]
                }
            }
        }
        printSolution(dist, n)
    }

    private fun minDistance(dist: IntArray, visited: BooleanArray): Int {
        var min = Int.MAX_VALUE
        var minIndex = -1
        for (v in 0 until n) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v]
                minIndex = v
            }
        }
        return minIndex
    }

    private fun printSolution(dist: IntArray, n: Int) {
        println("Vertex Distance from Source")
        for (i in 0 until n) {
            println(i.toString() + ": " + dist[i])
        }
    }
}

// main function
fun main(args: Array<String>) {
    val graph = arrayOf(intArrayOf(0, 4, 0, 0, 0, 0, 0, 8, 0),
            intArrayOf(4, 0, 8, 0, 0, 0, 0, 11, 0),
            intArrayOf(0, 8, 0, 7, 0, 4, 0, 0, 2),
            intArrayOf(0, 0, 7, 0, 9, 14, 0, 0, 0),
            intArrayOf(0, 0, 0, 9, 0, 10, 0, 0, 0),
            intArrayOf(0, 0, 4, 14, 10, 0, 2, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 2, 0, 1, 6),
            intArrayOf(8, 11, 0, 0, 0, 0, 1, 0, 7),
            intArrayOf(0, 0, 2, 0, 0, 0, 6, 7, 0))
    val t = Dijkstra(graph, 9)
    t.dijkstra(0)
}