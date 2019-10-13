package com.miracle.algorithm.search

class BinarySearch {

    /**
     * 이진검색
     *
     * [list]       Int list
     * [key]        Search key
     *
     * [return]     List index / ( -1 = key doesn't exist )
     */
    fun getBinarySearchResult(list: MutableList<Int>, key: Int): Int {
        list.sort()

        var pr = 0
        var pl = list.size - 1

        do {
            val pc = (pl + pr) / 2
            if (list[pc] == key) {
                return pc
            } else if (list[pc] < key) {
                pl = pc + 1
            } else if (list[pc] > key) {
                pr = pc - 1
            }
        } while (pl <= pr)

        return -1
    }
}