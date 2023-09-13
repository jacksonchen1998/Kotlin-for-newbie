import java.util.PriorityQueue

fun main() {
    // 創建一個最小堆
    val minHeap = PriorityQueue<Int>()

    // 添加元素到堆中
    minHeap.add(5)
    minHeap.add(2)
    minHeap.add(9)
    minHeap.add(1)
    minHeap.add(6)

    // 獲取最小元素（堆頂元素）
    val minElement = minHeap.poll()
    println("最小元素：$minElement")

    // 輸出剩餘的元素，它們將按照最小堆的順序出列
    println("剩餘元素：")
    while (!minHeap.isEmpty()) {
        val element = minHeap.poll()
        println(element)
    }
}
