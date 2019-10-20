package com.miracle.algorithm.etc

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class IntQueueTest{

    val intQueue = IntQueue(8)

    @Rule
    @JvmField
    val expectedException = ExpectedException.none()

    @Test
    fun successCapacity(){
        assertThat(intQueue.capacity(), IsEqual.equalTo(8))
    }

    @Test
    fun failDequeWhenEmpty(){
        expectedException.expect(IntQueue.EmptyIntQueueException::class.java)
        expectedException.expectMessage(IntQueue.EMPTY_INT_QUEUE_ERROR)
        intQueue.deque()
    }

    @Test
    fun successEnque(){
        intQueue.enque(123)
        assertThat(intQueue.peek(), IsEqual.equalTo(123))
    }

    @Test
    fun failEnqueWhenFull(){
        expectedException.expect(IntQueue.OverflowIntQueueException::class.java)
        expectedException.expectMessage(IntQueue.QUEUE_OVERFLOW_ERROR)

        intQueue.enque(125)
        intQueue.enque(121)
        intQueue.enque(122)
        intQueue.enque(11)
        intQueue.enque(13)
        intQueue.enque(51)
        intQueue.enque(23)
        intQueue.enque(53)
        intQueue.enque(163)
    }

    @Test
    fun successIsFull(){
        intQueue.enque(125)
        intQueue.enque(121)
        intQueue.enque(122)
        intQueue.enque(11)
        intQueue.enque(13)
        intQueue.enque(51)
        intQueue.enque(23)
        intQueue.enque(53)

        assertThat(intQueue.isFull(), IsEqual.equalTo(true))
    }

    @Test
    fun successCheckSize(){
        intQueue.enque(125)
        intQueue.enque(121)
        intQueue.enque(122)
        intQueue.enque(11)

        assertThat(intQueue.size(), IsEqual.equalTo(4))
    }

    @Test
    fun successIndexOf(){
        intQueue.enque(125)
        intQueue.enque(121)
        intQueue.enque(122)
        intQueue.enque(11)

        assertThat(intQueue.indexOf(122), IsEqual.equalTo(2))
    }

    @Test
    fun successClear(){
        intQueue.enque(125)
        intQueue.enque(121)
        intQueue.enque(122)
        intQueue.enque(11)
        intQueue.clear()
        assertThat(intQueue.size(), IsEqual.equalTo(0))
    }
}