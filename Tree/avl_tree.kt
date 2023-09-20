class Node(var key: Int, var left: Node? = null, var right: Node? = null, var height: Int = 1)

class AVLTree {
    var root: Node? = null

    fun height(node: Node?): Int {
        return node?.height ?: 0
    }

    fun updateHeight(node: Node?) {
        node?.height = 1 + maxOf(height(node?.left), height(node?.right))
    }

    fun getBalance(node: Node?): Int {
        return if (node == null) 0 else height(node.left) - height(node.right)
    }

    fun rotateRight(y: Node?): Node? {
        val x = y?.left
        val T2 = x?.right

        x?.right = y
        y?.left = T2

        updateHeight(y)
        updateHeight(x)

        return x
    }

    fun rotateLeft(x: Node?): Node? {
        val y = x?.right
        val T2 = y?.left

        y?.left = x
        x?.right = T2

        updateHeight(x)
        updateHeight(y)

        return y
    }

    fun insert(node: Node?, key: Int): Node? {
        if (node == null)
            return Node(key)

        if (key < node.key)
            node.left = insert(node.left, key)
        else if (key > node.key)
            node.right = insert(node.right, key)
        else
            return node

        updateHeight(node)

        val balance = getBalance(node)

        // Left Heavy
        if (balance > 1) {
            if (key < node.left!!.key) {
                return rotateRight(node)
            } else {
                node.left = rotateLeft(node.left)
                return rotateRight(node)
            }
        }

        // Right Heavy
        if (balance < -1) {
            if (key > node.right!!.key) {
                return rotateLeft(node)
            } else {
                node.right = rotateRight(node.right)
                return rotateLeft(node)
            }
        }

        return node
    }

    fun insert(key: Int) {
        root = insert(root, key)
    }

    fun inorderTraversal(node: Node?) {
        if (node != null) {
            inorderTraversal(node.left)
            println(node.key)
            inorderTraversal(node.right)
        }
    }

    fun delete(key: Int) {
        root = delete(root, key)
    }

    fun minValueNode(node: Node?): Node? {
        var currentNode = node
        while (currentNode?.left != null)
            currentNode = currentNode.left
        return currentNode
    }

    fun delete(node: Node?, key: Int): Node? {
        if (node == null)
            return node

        if (key < node.key)
            node.left = delete(node.left, key)
        else if (key > node.key)
            node.right = delete(node.right, key)
        else {
            if (node.left == null || node.right == null) {
                val temp = if (node.left != null) node.left else node.right
                return if (temp == null) null else temp
            }

            val temp = minValueNode(node.right)
            node.key = temp!!.key
            node.right = delete(node.right, temp.key)
        }

        updateHeight(node)

        val balance = getBalance(node)

        // Left Heavy
        if (balance > 1) {
            if (getBalance(node.left) >= 0) {
                return rotateRight(node)
            } else {
                node.left = rotateLeft(node.left)
                return rotateRight(node)
            }
        }

        // Right Heavy
        if (balance < -1) {
            if (getBalance(node.right) <= 0) {
                return rotateLeft(node)
            } else {
                node.right = rotateRight(node.right)
                return rotateLeft(node)
            }
        }

        return node
    }

    fun search(node: Node?, key: Int): Node? {
        if (node == null || node.key == key)
            return node

        return if (key < node.key) search(node.left, key) else search(node.right, key)
    }
}

fun main() {
    val avlTree = AVLTree()

    // Insert some keys into the AVL tree
    avlTree.insert(10)
    avlTree.insert(20)
    avlTree.insert(30)
    avlTree.insert(40)
    avlTree.insert(50)
    avlTree.insert(25)

    println("Inorder traversal of AVL tree:")
    avlTree.inorderTraversal(avlTree.root)
    
    // Search for a key
    val keyToSearch = 30
    val foundNode = avlTree.search(avlTree.root, keyToSearch)
    if (foundNode != null) {
        println("Key $keyToSearch found in the AVL tree.")
    } else {
        println("Key $keyToSearch not found in the AVL tree.")
    }

    // Delete a key
    val keyToDelete = 40
    avlTree.delete(keyToDelete)
    println("Inorder traversal after deleting $keyToDelete:")
    avlTree.inorderTraversal(avlTree.root)
}
