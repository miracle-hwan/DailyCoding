package com.miracle.algorithm.search

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.hamcrest.core.IsNot
import org.junit.Test

class SeqSearchTest {

    val list = listOf<Int>(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
    val seqSearch = SeqSearch()

    @Test
    fun successSearch() {
        val result = seqSearch.getSeqSearchResult(list, 3)
        assertThat(2, IsEqual(result))
    }

    @Test
    fun failSearchWhenCompareWrongIndex() {
        val result = seqSearch.getSeqSearchResult(list, 3)
        assertThat(1, IsNot.not(result))
    }

    @Test
    fun failSearchWhenCompareSecondIndex() {
        val result = seqSearch.getSeqSearchResult(list, 3)
        assertThat(7, IsNot.not(result))
    }

    @Test
    fun successSearchWhenCompareDoesntExistNumber() {
        val result = seqSearch.getSeqSearchResult(list, 9)
        assertThat(-1, IsEqual.equalTo(result))
    }
}