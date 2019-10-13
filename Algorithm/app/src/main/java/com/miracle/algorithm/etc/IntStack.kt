package com.miracle.algorithm.etc

import android.util.Log

class IntStack constructor(capacity: Int) {

    class EmptyIntStackException(message: String?) : RuntimeException(message)
    class OverflowIntStackException(message: String?) : RuntimeException(message)
    companion object {
        val STACK_OVERFLOW_ERROR = "StackOverflow"
        val EMPTY_INT_STACK_ERROR = "EmptyIntStack"
    }

    private var ptr = 0
    private var max = 0
    private lateinit var stack: IntArray

    init {
        try {
            max = capacity
            stack = IntArray(max)
        } catch (e: OutOfMemoryError) {
        }
    }

    @Throws(OverflowIntStackException::class)
    fun push(value: Int): Int {
        if (ptr >= max) {
            throw OverflowIntStackException(STACK_OVERFLOW_ERROR);
        }
        return stack.let {
            it.set(ptr++, value)
            value
        }
    }

    @Throws(EmptyIntStackException::class)
    fun pop(): Int {
        if (ptr <= 0) {
            throw EmptyIntStackException(EMPTY_INT_STACK_ERROR)
        }
        return stack[--ptr];
    }

    @Throws(EmptyIntStackException::class)
    fun peek(): Int {
        if (ptr <= 0) {
            throw EmptyIntStackException(EMPTY_INT_STACK_ERROR)
        }
        return stack[ptr - 1]
    }

    fun indexOf(value: Int): Int {
        for (i in ptr - 1 downTo 0) {
            if (value == stack[i]) {
                return i
            }
        }
        return -1
    }

    fun clear() {
        ptr = 0
    }

    fun capacity(): Int {
        return max
    }

    fun size(): Int {
        return ptr
    }

    fun isEmpty(): Boolean {
        return ptr <= 0
    }

    fun isFull(): Boolean {
        return ptr >= max
    }

    fun dump() {
        if (ptr <= 0) {
            Log.e(IntStack::class.java.name, "Stack is Empty")
        } else {
            for (i in 0..ptr - 1) {
                Log.e(IntStack::class.java.name, "Stack[${i}] = ${stack[i]}")
            }
        }
    }
}