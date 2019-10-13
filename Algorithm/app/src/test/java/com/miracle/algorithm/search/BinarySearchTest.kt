package com.miracle.algorithm.search

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Test

class BinarySearchTest {

    val list = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 13, 24, 563, 12, 64, 23, 14, 65, 88, 97)
    val binarySearch = BinarySearch()

    @Test
    fun successSearch(){
        assertThat(9 , IsEqual.equalTo(binarySearch.getBinarySearchResult(list, 12)))
    }

    @Test
    fun failSearchWhenDoesntExistValue(){
        assertThat(-1 , IsEqual.equalTo(binarySearch.getBinarySearchResult(list, 100)))
    }
}