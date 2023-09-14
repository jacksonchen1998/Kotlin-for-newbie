// Kotlin implement graph data structure
// The graph has directed edges, meaning that the edge points from one node to another.
class Graph<T> {
    private val nodes: MutableList<Node<T>> = mutableListOf()
    fun addNode(node: Node<T>) = nodes.add(node)
    fun removeNode(node: Node<T>) = nodes.remove(node)
    fun addEdge(source: Node<T>, destination: Node<T>) {
        if (!nodes.contains(source) || !nodes.contains(destination)) {
            throw Exception("Source and Destination nodes must be part of graph")
        }
        val edge = Edge(source, destination)
        source.addEdge(edge)
    }
    fun removeEdge(source: Node<T>, destination: Node<T>) {
        if (!nodes.contains(source) || !nodes.contains(destination)) {
            throw Exception("Source and Destination nodes must be part of graph")
        }
        val edge = Edge(source, destination)
        source.removeEdge(edge)
    }
    fun print() {
        nodes.forEach { node ->
            node.edges.forEach { edge ->
                println("${edge.source.value} -> ${edge.destination.value}")
            }
        }
    }
}

class Node<T>(val value: T) {
    var edges: MutableList<Edge<T>> = mutableListOf()
    fun addEdge(edge: Edge<T>) = edges.add(edge)
    fun removeEdge(edge: Edge<T>) = edges.remove(edge)
}

class Edge<T>(val source: Node<T>, val destination: Node<T>) {
    override fun equals(other: Any?): Boolean {
        if (other !is Edge<*>) {
            return false
        }
        return source == other.source && destination == other.destination
    }
}

fun main() {
    val graph = Graph<String>()
    val nodeA = Node("A")
    val nodeB = Node("B")
    val nodeC = Node("C")
    val nodeD = Node("D")
    val nodeE = Node("E")
    val nodeF = Node("F")
    val nodeG = Node("G")
    val nodeH = Node("H")
    val nodeI = Node("I")
    graph.addNode(nodeA)
    graph.addNode(nodeB)
    graph.addNode(nodeC)
    graph.addNode(nodeD)
    graph.addNode(nodeE)
    graph.addNode(nodeF)
    graph.addNode(nodeG)
    graph.addNode(nodeH)
    graph.addNode(nodeI)
    graph.addEdge(nodeA, nodeB)
    graph.addEdge(nodeA, nodeC)
    graph.addEdge(nodeA, nodeD)
    graph.addEdge(nodeB, nodeE)
    graph.addEdge(nodeB, nodeF)
    graph.addEdge(nodeC, nodeG)
    graph.addEdge(nodeC, nodeH)
    graph.addEdge(nodeD, nodeI)
    graph.print()
    // A -> B
    // A -> C
    // A -> D
    // B -> E
    // B -> F
    // C -> G
    // C -> H
    // D -> I
    graph.removeEdge(nodeA, nodeB)
    graph.removeEdge(nodeA, nodeC)
    graph.removeEdge(nodeA, nodeD)
    graph.removeEdge(nodeB, nodeE)
    graph.removeEdge(nodeB, nodeF)
    graph.removeEdge(nodeC, nodeG)
    graph.removeEdge(nodeC, nodeH)
    graph.removeEdge(nodeD, nodeI)
    graph.print()
    // graph.removeNode(nodeA)
    // graph.removeNode(nodeB)
    // graph.removeNode(nodeC)
    // graph.removeNode(nodeD)
    // graph.removeNode(nodeE)
    // graph.removeNode(nodeF)
    // graph.removeNode(nodeG)
    // graph.removeNode(nodeH)
    // graph.removeNode(nodeI)
    // graph.print()
}