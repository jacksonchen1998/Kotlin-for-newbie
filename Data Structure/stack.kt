import java.util.ArrayDeque

fun main() {
    val stack = ArrayDeque<Int>()

    // 推入元素到堆疊
    stack.push(1)
    stack.push(2)
    stack.push(3)

    // 彈出元素
    val poppedElement = stack.pop()
    println("Popped element: $poppedElement") // 輸出 3
}
