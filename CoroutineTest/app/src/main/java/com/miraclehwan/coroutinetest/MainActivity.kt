package com.miraclehwan.coroutinetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        test9()
        Log.e("Main End")
    }

    fun test9() = runBlocking {
        GlobalScope.launch {
            repeat(100){i ->
                Log.e("I'm sleeping ${i}")
                delay(500L)
            }
        }
        delay(1300L)
        Log.e("test9 Function End")
    }

    fun test8() = runBlocking {
        repeat(100_000){
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

    suspend fun doWorld(){
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

    fun test3() = runBlocking{
        GlobalScope.launch {
            delay(1000L)
            Log.e("World!")
        }
        Log.e("Hello, ")
        delay(2000L)
    }

    fun test2(){
        GlobalScope.launch {
            delay(1000L)
            Log.e("World!")
        }
        Log.e("Hello, ")
        runBlocking {
            delay(2000L)
        }
    }

    fun test(){
        GlobalScope.launch {
            delay(1000L)
            Log.e("First Coroutine !!!");
        }
        Log.e("First Coroutine ");
        Thread.sleep(2000L)
    }
}
