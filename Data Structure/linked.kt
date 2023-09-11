import java.util.LinkedList

fun main() {
    val linkedList = LinkedList<String>()

    linkedList.add("Apple")
    linkedList.add("Banana")
    linkedList.add("Cherry")

    for (item in linkedList) {
        println(item)
    }

    // remove
    linkedList.remove("Banana")
    println("After removing Banana:")
    for (item in linkedList) {
        println(item)
    }

    // addFirst
    linkedList.addFirst("Banana")
    println("After adding Banana to the first:")
    for (item in linkedList) {
        println(item)
    }

    // addLast
    linkedList.addLast("Watermelon")
    println("After adding Banana to the last:")
    for (item in linkedList) {
        println(item)
    }

    // size
    println("Size of linked list: ${linkedList.size}")
}
