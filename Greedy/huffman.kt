import java.util.SortedSet

fun main(args: Array<String>) {

    val input = "A_DEAD_DAD_CEDED_A_BAD_BABE_A_BEADED_ABACA_BED"

    val huffmanTree = createHuffmanTree(input)

    val encoder = encoder(huffmanTree)
    val decoder = decoder(huffmanTree)

    val expected = "1000011101001000110010011101100111001001000111110010011111011111100010001111110100111001001011111011101000111111001"

    check(expected == encoder(input)) { "expected did not match encoded result" }
    check(input == decoder(encoder(input))) { "decoding expected did not match input" }
}

fun encoder(huffmanTree: Node): (String) -> String {
    val dictionary = createDictionary(huffmanTree)
    return { input -> input.map { dictionary[it] }.joinToString(separator = "") }
}

fun decoder(huffmanTree: Node): (String) -> String {
    return { input ->
        var remaining = input
        var result = ""
        while (remaining.isNotEmpty()) {
            val (left, answer) = readPath(huffmanTree, remaining)
            result += answer
            remaining = left
        }
        result
    }
}

/**
 * Partially reads a portion of the encoded value and returns the un-read portion of the encoded value and a decoded
 * fragment.
 */
private fun readPath(node: Node, path: String) : Pair<String, String> {
    if (node.left == null || node.right == null) {
        return Pair(path, node.value)
    }
    return when (path[0]) {
        '0' -> readPath(node.left, path.subSequence(1, path.length).toString())
        '1' -> readPath(node.right, path.subSequence(1, path.length).toString())
        else -> Pair("", "")
    }
}

/**
 * Creates a huffman tree based on the input string and the letter frequency analysis of that input string.
 */
fun createHuffmanTree(input: String): Node {
    val nodes = readFrequencies(input)
    while (nodes.size != 1) {
        val (a, b) = nodes.take(2)
        nodes.removeAll(listOf(a, b))
        nodes.add(Node(a.value + b.value, a.freq + b.freq, a, b))
    }
    return nodes.first()
}

/**
 * Creates a set of character nodes and their frequencies, ordered by least frequent first.
 */
private fun readFrequencies(input: String): SortedSet<Node> {
    return input.groupBy { it }
            .mapValues { it.value.size }
            .map { Node(it.key.toString(), it.value) }
            .toSortedSet()
}

/**
 * Creates a dictionary from each leaf character to the path of how to traverse the tree to that leaf.
 */
private fun createDictionary(node: Node, path: String = "") : Map<Char, String> {
    if (node.left == null || node.right == null) {
        check(node.value.length == 1) { "leaf should only contain a single character" }
        return mapOf(Pair(node.value.toCharArray()[0], path))
    }
    return createDictionary(node.left, path + "0") + createDictionary(node.right, path + "1")
}

data class Node(val value: String,
                val freq: Int,
                val left: Node? = null,
                val right: Node? = null) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        val i = this.freq.compareTo(other.freq)
        return when (i) {
            0 -> other.value.compareTo(this.value)
            else -> i
        }
    }
}