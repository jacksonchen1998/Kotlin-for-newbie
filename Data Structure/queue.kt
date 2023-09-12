import java.util.ArrayDeque

fun main() {
    val queue = ArrayDeque<Int>()

    // 將元素添加到佇列尾部
    queue.offer(1)
    queue.offer(2)
    queue.offer(3)

    // 取出佇列的頭元素
    val polledElement = queue.poll()
    println("Polled element: $polledElement") // 輸出 1
}