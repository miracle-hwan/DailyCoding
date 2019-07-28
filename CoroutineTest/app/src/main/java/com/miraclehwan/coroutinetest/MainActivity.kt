package com.miraclehwan.coroutinetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlin.system.measureNanoTime

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        test14()
        Log.e("Main End")
    }

    fun test14() = runBlocking {
        val time = measureNanoTime {
            val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
            val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
            Log.e("The answer is ${one.await() + two.await()}")
        }
        Log.e("Completed in ${time} ms")
    }

    fun test13() = runBlocking {
        val time = measureNanoTime {
            val one = async { doSomethingUsefulOne() }
            val two = async { doSomethingUsefulTwo() }
            Log.e("The answer is ${one.await() + two.await()}")
        }
        Log.e("Completed in ${time} ms")
    }

    suspend fun doSomethingUsefulOne():Int {
        delay(1000L)
        return 13
    }

    suspend fun doSomethingUsefulTwo():Int {
        delay(1000L)
        return 29
    }

    fun test12() = runBlocking {
        val result = withTimeoutOrNull(1000L){
            repeat(1){
                Log.e("I'm sleeping ${it} ...")
                delay(500L)
            }
            "Done"
        }
        Log.e("Result is ${result}")
    }

    fun test11() = runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0;
            while (isActive) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    Log.e("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L)
        Log.e("main: I'm tried of waiting!")
        job.cancelAndJoin()
        Log.e("main: Now I can quit")
    }

    fun test10() = runBlocking {
        val job = launch {
            repeat(1000) {
                Log.e("job : I'm sleeping ${it} ...")
                delay(500L)
            }
        }
        delay(1300L)
        Log.e("main : I'm tried of waiting!")
        job.cancel()
        job.join()
        Log.e("main: Now I can quit")
    }

    fun test9() = runBlocking {
        GlobalScope.launch {
            repeat(100) { i ->
                Log.e("I'm sleeping ${i}")
                delay(500L)
            }
        }
        delay(1300L)
        Log.e("test9 Function End")
    }

    fun test8() = runBlocking {
        repeat(100_000) {
            launch {
                delay(10000L)
                Log.e(".")
            }
        }
    }

    fun test7() = runBlocking {
        launch { doWorld() }
        Log.e("Hello, ")
        Log.e("Test7 End")
    }

    suspend fun doWorld() {
        delay(1000L)
        Log.e("World!")
    }

    fun test6() = runBlocking {
        launch {
            delay(2000L)
            Log.e("Task from runBlocking")
        }

        coroutineScope {
            launch {
                delay(5000L)
                Log.e("Task from nested lauch")
            }

            delay(1000L)
            Log.e("Task from coroutine scope")
        }

        Log.e("Coroutine scope is over")
    }

    fun test5() = runBlocking {
        launch {
            delay(1000L)
            Log.e("World!")
        }
        Log.e("Hello, ")
        delay(5000L)
        Log.e("Function End")
    }

    fun test4() = runBlocking {
        var job = GlobalScope.launch {
            delay(1000L)
            Log.e("World!")
        }
        Log.e("Hello, ")
        job.join()
        Log.e("Join End")
        delay(5000L)
        Log.e("Function End")
    }

    fun test3() = runBlocking {
        GlobalScope.launch {
            delay(1000L)
            Log.e("World!")
        }
        Log.e("Hello, ")
        delay(2000L)
    }

    fun test2() {
        GlobalScope.launch {
            delay(1000L)
            Log.e("World!")
        }
        Log.e("Hello, ")
        runBlocking {
            delay(2000L)
        }
    }

    fun test() {
        GlobalScope.launch {
            delay(1000L)
            Log.e("First Coroutine !!!");
        }
        Log.e("First Coroutine ");
        Thread.sleep(2000L)
    }
}
