class HashTable<K, V> {
    private val table: HashMap<K, V> = HashMap()

    // 將鍵值對添加到哈希表
    fun put(key: K, value: V) {
        table[key] = value
    }

    // 根據鍵獲取值
    fun get(key: K): V? {
        return table[key]
    }

    // 刪除特定鍵的值
    fun remove(key: K) {
        table.remove(key)
    }

    // 檢查哈希表是否包含特定鍵
    fun containsKey(key: K): Boolean {
        return table.containsKey(key)
    }

    // 返回哈希表中所有鍵的集合
    fun keys(): Set<K> {
        return table.keys
    }

    // 返回哈希表中所有值的集合
    fun values(): Collection<V> {
        return table.values
    }

    // 返回哈希表的大小（存儲的鍵值對數量）
    fun size(): Int {
        return table.size
    }

    // 檢查哈希表是否為空
    fun isEmpty(): Boolean {
        return table.isEmpty()
    }
}

fun main() {
    val hashTable = HashTable<String, Int>()

    hashTable.put("Alice", 25)
    hashTable.put("Bob", 30)
    hashTable.put("Charlie", 35)

    println("Alice's age: ${hashTable.get("Alice")}")
    println("Bob's age: ${hashTable.get("Bob")}")

    hashTable.remove("Charlie")
    println("Is Charlie in the hash table? ${hashTable.containsKey("Charlie")}")

    println("Keys in the hash table: ${hashTable.keys()}")
    println("Values in the hash table: ${hashTable.values()}")
    println("Size of the hash table: ${hashTable.size()}")
    println("Is the hash table empty? ${hashTable.isEmpty()}")
}
