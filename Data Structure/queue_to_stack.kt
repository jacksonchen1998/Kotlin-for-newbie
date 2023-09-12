import java.util.LinkedList

class StackWithQueue<T> {
    private val queue = LinkedList<T>()

    fun push(item: T) {
        // 將元素添加到佇列的尾部
        queue.offer(item)
    }

    fun pop(): T? {
        // 將佇列中除了最後一個元素外的其他元素重新排列到佇列中
        val size = queue.size
        for (i in 0 until size - 1) {
            queue.offer(queue.poll())
        }
        // 取出最後一個元素，模擬堆疊的行為
        return if (size > 0) {
            queue.poll()
        } else {
            null
        }
    }
}

// 測試程式
fun main() {
    val stack = StackWithQueue<Int>()

    // 推入元素到堆疊
    stack.push(1)
    stack.push(2)
    stack.push(3)

    // 彈出元素
    val poppedElement = stack.pop()
    println("Popped element: $poppedElement") // 輸出 3
}