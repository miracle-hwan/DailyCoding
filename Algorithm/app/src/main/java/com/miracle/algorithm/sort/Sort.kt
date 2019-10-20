package com.miracle.algorithm.sort

class Sort {

    fun swap(array: IntArray, index1: Int, index2: Int) {
        val temp = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }

    fun bubbleSort(array: IntArray): Int {
        var count = 0
        var isSwap: Boolean
        var last = 0
        do {
            isSwap = false
            for (i in array.size - 2 downTo last) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1)
                    isSwap = true
                    last = i
                }
            }
            if (isSwap) {
                count++
            }
        } while (isSwap)
        return count
    }

    fun selectionSort(array: IntArray) {
        for (i in 0 until array.size) {
            var min = i
            for (j in i + 1 until array.size) {
                if (array[j] < array[min]) {
                    min = j
                }
            }
            swap(array, i, min)
        }
    }

    fun insertionSort(array: IntArray) {
        for (i in 1 until array.size) {
            val temp = array[i]
            var j = i
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1]
                j -= 1
            }
            array[j] = temp
        }
    }

    fun quickSort(array: IntArray, left: Int, right: Int) {
        var pl = left;
        var pr = right
        val pivot = array[(pl + pr) / 2]

        do {
            while (array[pl] < pivot) {
                pl++
            }
            while (array[pr] < pivot) {
                pr--
            }
            if (pl <= pr) {
                swap(array, pl++, pr--)
            }
        } while (pl <= pr)

        if (left < pr) {
            quickSort(array, left, pr)
        }
        if (pl < right) {
            quickSort(array, pl, right)
        }
    }
}