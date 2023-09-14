// Kotlin implement tree data structure
class TreeNode<T>(val value: T) {
    var children: MutableList<TreeNode<T>> = mutableListOf()
    fun add(child: TreeNode<T>) = children.add(child)
    fun remove(child: TreeNode<T>) = children.remove(child)
    override fun toString(): String {
        var s = "${value}"
        if (!children.isEmpty()) {
            s += " {" + children.map { it.toString() }.joinToString(", ") + " }"
        }
        return s
    }
}

// Tree overview
// beverages
// ├── hot
// │   ├── tea
// │   │   ├── black tea
// │   │   ├── green tea
// │   │   └── chai tea
// │   ├── coffee (removed)
// │   └── cocoa
// └── cold
//     ├── soda
//     │   ├── ginger ale
//     │   └── bitter lemon
//     └── milk


fun main() {
    val tree = TreeNode("beverages")
    val hot = TreeNode("hot")
    val cold = TreeNode("cold")
    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val cocoa = TreeNode("cocoa")
    val blackTea = TreeNode("black tea")
    val greenTea = TreeNode("green tea")
    val chaiTea = TreeNode("chai tea")
    val soda = TreeNode("soda")
    val milk = TreeNode("milk")
    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")
    tree.add(hot)
    tree.add(cold)
    hot.add(tea)
    hot.add(coffee)
    hot.add(cocoa)
    cold.add(soda)
    cold.add(milk)
    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)
    soda.add(gingerAle)
    soda.add(bitterLemon)
    println(tree)
    // remove an item
    hot.remove(coffee)
    println(tree)
}
