package com.miracle.algorithm.search

class SeqSearch {

    /**
     * 선형검색
     *
     * [list]       list
     * [key]        search key
     *
     * [return]     list index / ( -1 = key doesn't exist )
     */
    fun getSeqSearchResult(list: List<Int>, key: Int): Int {
        list.forEachIndexed { index, item ->
            if (key == item) {
                return index
            }
        }
        return -1
    }
}