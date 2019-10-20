package com.miracle.algorithm.sort

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Test

class SortTest {

    val sort = Sort()

    @Test
    fun successBubbleSort() {
        val intArray = intArrayOf(22, 5, 11, 32, 120, 68, 70)

        sort.bubbleSort(intArray)
        assertThat(intArray, IsEqual.equalTo(intArrayOf(5, 11, 22, 32, 68, 70, 120)))
    }

    @Test
    fun successBubbleSortCount() {
        val intArray = intArrayOf(1, 3, 9, 4, 10, 6, 7, 8)
        assertThat(4, IsEqual.equalTo(sort.bubbleSort(intArray)))
        assertThat(intArray, IsEqual.equalTo(intArrayOf(1, 3, 4, 6, 7, 8, 9, 10)))
    }

    @Test
    fun successBubbleSortCount2() {
        val intArray = intArrayOf(11, 1, 3, 9, 4, 10, 6, 7, 8)
        assertThat(8, IsEqual.equalTo(sort.bubbleSort(intArray)))
        assertThat(intArray, IsEqual.equalTo(intArrayOf(1, 3, 4, 6, 7, 8, 9, 10, 11)))
    }

    @Test
    fun selectionSort() {
        val intArray = intArrayOf(22, 5, 11, 32, 120, 68, 70)

        sort.selectionSort(intArray)
        assertThat(intArray, IsEqual.equalTo(intArrayOf(5, 11, 22, 32, 68, 70, 120)))
    }

    @Test
    fun insertionSort() {
        val intArray = intArrayOf(22, 5, 11, 32, 120, 68, 70)

        sort.insertionSort(intArray)
        assertThat(intArray, IsEqual.equalTo(intArrayOf(5, 11, 22, 32, 68, 70, 120)))
    }
}