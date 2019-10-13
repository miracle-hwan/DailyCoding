package com.miracle.algorithm.etc

import android.util.Log

class IntQueue constructor(capacity: Int) {

    class EmptyIntQueueException(message: String?) : RuntimeException(message)
    class OverflowIntQueueException(message: String?) : RuntimeException(message)

    companion object {
        val QUEUE_OVERFLOW_ERROR = "QueueOverflow"
        val EMPTY_INT_QUEUE_ERROR = "EmptyIntQueue"
    }

    var max = 0
    var front = 0
    var rear = 0
    var num = 0
    lateinit var queue: IntArray

    init {
        num = 0
        front = 0
        rear = 0
        max = capacity
        try {
            queue = IntArray(max)
        } catch (e: OutOfMemoryError) {
        }
    }

    @Throws(OverflowIntQueueException::class)
    fun enque(value: Int): Int {
        if (num >= max) {
            throw OverflowIntQueueException(QUEUE_OVERFLOW_ERROR)
        }
        queue[rear++] = value
        num++
        if (rear == max) {
            rear = 0
        }
        return value
    }

    @Throws(EmptyIntQueueException::class)
    fun deque(): Int {
        if (num <= 0) {
            throw EmptyIntQueueException(EMPTY_INT_QUEUE_ERROR)
        }
        val value = queue[front++]
        num--
        if (front == max) {
            front = 0
        }
        return value
    }

    fun peek(): Int {
        if (num <= 0) {
            throw EmptyIntQueueException(EMPTY_INT_QUEUE_ERROR)
        }
        return queue[front]
    }

    fun indexOf(input: Int): Int {
        if (num <= 0) {
            throw EmptyIntQueueException(EMPTY_INT_QUEUE_ERROR)
        }
        for (i in 0..num - 1) {
            val idx = (i + front) % max
            if (queue[idx] == input) {
                return idx
            }
        }
        return -1
    }

    fun clear() {
        num = 0
        front = 0
        rear = 0
    }

    fun capacity(): Int {
        return max
    }

    fun size(): Int {
        return num
    }

    fun isEmpty(): Boolean {
        return num <= 0
    }

    fun isFull(): Boolean {
        return num >= max
    }

    fun dump() {
        if (num <= 0) {
            Log.e(this.javaClass.name, "Queue is Empty")
        } else {
            for (i in 0..num) {
                val idx = (i + front) % max
                Log.e(this.javaClass.name, "Queue [${idx}] = ${queue[idx]}")
            }
        }
    }

}