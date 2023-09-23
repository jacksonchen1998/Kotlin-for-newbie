// Topology sort using DFS in Kotlin

import java.util.Stack

class Graph(private val n: Int) {
    private val adj: Array<MutableList<Int>> = Array(n) { mutableListOf() }

    fun addEdge(u: Int, v: Int) {
        adj[u].add(v)
    }

    private fun dfs(v: Int, visited: BooleanArray, stack: Stack<Int>) {
        visited[v] = true
        for (i in adj[v]) {
            if (!visited[i]) {
                dfs(i, visited, stack)
            }
        }
        stack.push(v)
    }

    fun topologicalSort(): Stack<Int> {
        val visited = BooleanArray(n)
        val stack = Stack<Int>()
        for (i in 0 until n) {
            if (!visited[i]) {
                dfs(i, visited, stack)
            }
        }
        return stack
    }
}

fun main(args: Array<String>) {
    val g = Graph(6)
    g.addEdge(5, 2)
    g.addEdge(5, 0)
    g.addEdge(4, 0)
    g.addEdge(4, 1)
    g.addEdge(2, 3)
    g.addEdge(3, 1)
    val stack = g.topologicalSort()
    while (!stack.isEmpty()) {
        print(stack.pop().toString() + " ")
    }
}