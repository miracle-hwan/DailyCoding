package com.miracle.algorithm.etc


import com.miracle.algorithm.etc.PrimeNumber
import org.junit.Test
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.hamcrest.core.IsNot

class PrimeNumberTest{

    val primeNumber = PrimeNumber()

    @Test
    fun successContainPrimeNumber(){
        val checkNumber = 7
        val primeNumberList = primeNumber.getPrimeNumberListBtwZeroToInputNumber(1000)
        assertThat(true, IsEqual.equalTo(primeNumberList.contains(checkNumber)))
    }

    @Test
    fun failContainNotPrimeNumber(){
        val checkNumber = 300
        val primeNumberList = primeNumber.getPrimeNumberListBtwZeroToInputNumber(1000)
        assertThat(false, IsEqual.equalTo(primeNumberList.contains(checkNumber)))
    }

    @Test
    fun successPrimeNumberSize(){
        val size = 4
        val primeNumberList = primeNumber.getPrimeNumberListBtwZeroToInputNumber(10)
        assertThat(size, IsEqual.equalTo(primeNumberList.size))
    }

    @Test
    fun failPrimeNumberSize(){
        val size = 3
        val primeNumberList = primeNumber.getPrimeNumberListBtwZeroToInputNumber(10)
        assertThat(size, IsNot.not(primeNumberList.size))
    }
}