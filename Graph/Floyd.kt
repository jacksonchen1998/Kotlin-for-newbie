// Floyd-Warshall Algorithm in Kotlin

// INF 
val INF = 99999

class FloydWarshall {

    // Number of vertices in the graph
    private val V = 4

    // Define infinity as the large enough value. This value will be
    // used for vertices not connected to each other
    private val INF = 99999

    // Solves the all-pairs shortest path problem using Floyd Warshall algorithm
    fun floydWarshall(graph: Array<IntArray>) {
        /* dist[][] will be the output matrix that will finally
        have the shortest distances between every pair of vertices */
        val dist = Array(V) { IntArray(V) }
        var i: Int
        var j: Int
        var k: Int

        /* Initialize the solution matrix same as input graph matrix.
        Or we can say the initial values of shortest distances
        are based on shortest paths considering no intermediate
        vertex. */
        i = 0
        while (i < V) {
            j = 0
            while (j < V) {
                dist[i][j] = graph[i][j]
                j++
            }
            i++
        }

        /* Add all vertices one by one to the set of intermediate
        vertices.
        ---> Before start of an iteration, we have shortest
        distances between all pairs of vertices such that
        the shortest distances consider only the vertices in
        set {0, 1, 2, .. k-1} as intermediate vertices.
        ----> After the end of an iteration, vertex no. k is
        added to the set of intermediate vertices and the
        set becomes {0, 1, 2, .. k} */
        k = 0
        while (k < V) {
            // Pick all vertices as source one by one
            i = 0
            while (i < V) {
                // Pick all vertices as destination for the
                // above picked source
                j = 0
                while (j < V) {
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j]
                    j++
                }
                i++
            }
            k++
        }

        // Print the shortest distance matrix
        printSolution(dist)
    }

    /* A utility function to print solution */
    fun printSolution(dist: Array<IntArray>) {
        println("The following matrix shows the shortest " + "distances between every pair of vertices")
        var i = 0
        while (i < V) {
            var j = 0
            while (j < V) {
                if (dist[i][j] == INF)
                    print("%7s".format("INF"))
                else
                    print("%7d".format(dist[i][j]))
                j++
            }
            println()
            i++
        }
    }
}

// main function
fun main(args: Array<String>) {
    /* Let us create the following weighted graph
            10
    (0)------->(3)
        |     /|\
    5 |     |
        |     | 1
    \|/     |
    (1)------->(2)
            3     */
    val graph = arrayOf(intArrayOf(0, 5, INF, 10),
            intArrayOf(INF, 0, 3, INF),
            intArrayOf(INF, INF, 0, 1),
            intArrayOf(INF, INF, INF, 0))
    val a = FloydWarshall()

    // Print the solution
    a.floydWarshall(graph)
}