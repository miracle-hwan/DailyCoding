package com.miracle.algorithm.recursive

class EuclidGCD {

    fun gcd(x: Int, y: Int): Int {
        if (y == 0) {
            return x
        } else {
            return gcd(y, x % y)
        }
    }
}
