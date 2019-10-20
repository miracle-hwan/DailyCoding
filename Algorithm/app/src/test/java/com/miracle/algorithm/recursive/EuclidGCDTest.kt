package com.miracle.algorithm.recursive

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Test

class EuclidGCDTest{

    val euclidGCD = EuclidGCD()

    @Test
    fun successGCD(){
        assertThat(euclidGCD.gcd(22,8), IsEqual.equalTo(2))
    }

    @Test
    fun successGCD_2(){
        assertThat(euclidGCD.gcd(12237,238953), IsEqual.equalTo(3))
    }
}