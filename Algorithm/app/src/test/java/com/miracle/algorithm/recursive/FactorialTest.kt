package com.miracle.algorithm.recursive


import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.hamcrest.core.IsNot
import org.junit.Test

class FactorialTest{

    val factorial = Factorial()

    @Test
    fun successFactorial5(){
        assertThat(factorial.factorial(5), IsEqual.equalTo(120))
    }

    @Test
    fun failFactorial5(){
        assertThat(factorial.factorial(5), IsNot.not(5))
    }
}