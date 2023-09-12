import java.util.Stack

class QueueWithStacks<T> {
    private val stack1 = Stack<T>()
    private val stack2 = Stack<T>()

    fun enqueue(item: T) {
        // 將元素壓入 stack1
        stack1.push(item)
    }

    fun dequeue(): T? {
        // 如果 stack2 是空的，將 stack1 中的元素進行反轉，然後壓入 stack2
        if (stack2.isEmpty()) {
            while (stack1.isNotEmpty()) {
                stack2.push(stack1.pop())
            }
        }
        // 從 stack2 中彈出元素，實現佇列的行為
        return if (stack2.isNotEmpty()) {
            stack2.pop()
        } else {
            null
        }
    }
}

// 測試程式
fun main() {
    val queue = QueueWithStacks<Int>()

    // 將元素添加到佇列尾部
    queue.enqueue(7)
    queue.enqueue(8)
    queue.enqueue(9)

    // 取出佇列的頭元素
    val polledElement = queue.dequeue()
    println("Polled element: $polledElement") // 輸出 1
}