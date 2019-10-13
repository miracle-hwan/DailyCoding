package com.miracle.algorithm.etc

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.hamcrest.core.IsNot
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class IntStackTest {

    val intStack = IntStack(8)

    @Rule
    @JvmField
    val expectedException = ExpectedException.none()

    @Test
    fun successCapacityCheck() {
        assertThat(8, IsEqual.equalTo(intStack.capacity()))
    }

    @Test
    fun successEmptyCheck() {
        assertThat(true, IsEqual.equalTo(intStack.isEmpty()))
    }

    @Test
    fun successFullCheck() {
        intStack.push(100)
        intStack.push(200)
        intStack.push(100)
        intStack.push(200)
        intStack.push(100)
        intStack.push(200)
        intStack.push(100)
        intStack.push(200)

        assertThat(8, IsEqual.equalTo(intStack.size()))
        assertThat(true, IsEqual.equalTo(intStack.isFull()))
    }

    @Test
    fun successStackOverFlowException(){
        expectedException.expect(IntStack.OverflowIntStackException::class.java)
        expectedException.expectMessage(IntStack.STACK_OVERFLOW_ERROR)
        intStack.push(100)
        intStack.push(100)
        intStack.push(100)
        intStack.push(100)
        intStack.push(100)
        intStack.push(100)
        intStack.push(100)
        intStack.push(100)
        intStack.push(100)
        intStack.push(100)
    }

    @Test
    fun successEmptyExceptionWhenCallPeek(){
        expectedException.expect(IntStack.EmptyIntStackException::class.java)
        expectedException.expectMessage(IntStack.EMPTY_INT_STACK_ERROR)
        intStack.peek()
    }

    @Test
    fun successEmptyExceptionWhenCallPop(){
        expectedException.expect(IntStack.EmptyIntStackException::class.java)
        expectedException.expectMessage(IntStack.EMPTY_INT_STACK_ERROR)
        intStack.pop()
    }

    @Test
    fun successIndexOf(){
        intStack.push(100)
        intStack.push(200)
        intStack.push(300)
        intStack.push(100)
        intStack.push(500)
        assertThat(3, IsEqual.equalTo(intStack.indexOf(100)))
    }

    @Test
    fun failIndexOf(){
        intStack.push(100)
        intStack.push(200)
        intStack.push(300)
        intStack.push(100)
        intStack.push(500)
        assertThat(1, IsNot.not(intStack.indexOf(100)))
    }

    @Test
    fun failCapacityCheck() {
        assertThat(7, IsNot.not(intStack.capacity()))
    }

    @Test
    fun successPushValueAndCheckStack() {
        intStack.push(100)

        assertThat(1, IsEqual.equalTo(intStack.size()))
        assertThat(100, IsEqual.equalTo(intStack.peek()))
    }

    @Test
    fun successPushValuesAndCheckStack() {
        intStack.push(100)
        intStack.push(200)

        assertThat(2, IsEqual.equalTo(intStack.size()))
        assertThat(200, IsEqual.equalTo(intStack.peek()))
    }

    @Test
    fun falsePushValuesAndCheckStack() {
        intStack.push(100)
        intStack.push(200)

        assertThat(2, IsEqual.equalTo(intStack.size()))
        assertThat(100, IsNot.not(intStack.peek()))
    }

    @Test
    fun successPopValueAndCheckStack() {
        intStack.push(100)
        intStack.push(200)

        intStack.pop()

        assertThat(1, IsEqual.equalTo(intStack.size()))
        assertThat(100, IsEqual.equalTo(intStack.peek()))
    }

    @Test
    fun successClearStack() {
        intStack.push(100)
        intStack.push(200)

        intStack.pop()

        intStack.push(300)
        intStack.push(400)

        assertThat(3, IsEqual.equalTo(intStack.size()))

        intStack.clear()

        assertThat(0, IsEqual.equalTo(intStack.size()))
    }
}