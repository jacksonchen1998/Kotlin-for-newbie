// Binary Search Tree
// Just a simple binary search tree implementation.

class TreeNode(var key: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinarySearchTree {
    var root: TreeNode? = null

    fun insert(key: Int) {
        root = insertRec(root, key)
    }

    private fun insertRec(root: TreeNode?, key: Int): TreeNode {
        if (root == null) {
            return TreeNode(key)
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key)
        } else if (key > root.key) {
            root.right = insertRec(root.right, key)
        }

        return root
    }

    fun search(key: Int): Boolean {
        return searchRec(root, key)
    }

    private fun searchRec(root: TreeNode?, key: Int): Boolean {
        if (root == null) {
            return false
        }

        if (key == root.key) {
            return true
        }

        return if (key < root.key) {
            searchRec(root.left, key)
        } else {
            searchRec(root.right, key)
        }
    }

    fun delete(key: Int) {
        root = deleteRec(root, key)
    }

    private fun deleteRec(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) {
            return root
        }

        if (key < root.key) {
            root.left = deleteRec(root.left, key)
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key)
        } else {
            if (root.left == null) {
                return root.right
            } else if (root.right == null) {
                return root.left
            }

            root.key = minValue(root.right!!)
            root.right = deleteRec(root.right, root.key)
        }

        return root
    }

    private fun minValue(node: TreeNode): Int {
        var current = node
        while (current.left != null) {
            current = current.left!!
        }
        return current.key
    }
}

fun main() {
    val tree = BinarySearchTree()

    // Insert some values into the BST
    tree.insert(50)
    tree.insert(30)
    tree.insert(20)
    tree.insert(40)
    tree.insert(70)
    tree.insert(60)
    tree.insert(80)

    // Search for values in the BST
    val keyToSearch = 40
    if (tree.search(keyToSearch)) {
        println("$keyToSearch found in the BST.")
    } else {
        println("$keyToSearch not found in the BST.")
    }

    // Delete a value from the BST
    val keyToDelete = 30
    tree.delete(keyToDelete)
    println("After deleting $keyToDelete:")
    if (tree.search(keyToDelete)) {
        println("$keyToDelete found in the BST.")
    } else {
        println("$keyToDelete not found in the BST.")
    }
}
