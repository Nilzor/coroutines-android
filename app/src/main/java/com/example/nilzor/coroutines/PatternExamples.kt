package com.example.nilzor.coroutines

import android.util.Log
import kotlinx.coroutines.experimental.*
import java.util.concurrent.ForkJoinPool

object PatternExamples {
    fun serial() = runBlocking<Unit> {
        val job1 = async(CommonPool) { doWorld() }
        val job2 = async(CommonPool) { doWorld() }
        job1.await()
        job2.await()
    }

    suspend fun doWorld() {
        println("World!")
    }

    fun blockingThreads() {
        val pool= ForkJoinPool.commonPool()
        Log.d(HttpExamples.TAG,"Launching blocking coroutines... CommonPool thread count: " + pool.parallelism  )
        launch(CommonPool) {
            Log.d(HttpExamples.TAG, "A")
            Thread.sleep(100L)
        }
        launch(CommonPool) {
            Log.d(HttpExamples.TAG, "B")
            Thread.sleep(100L)
        }
        launch(CommonPool) {
            Log.d(HttpExamples.TAG, "C")
            Thread.sleep(100L)
        }
        launch(CommonPool) {
            Log.d(HttpExamples.TAG, "D")
            Thread.sleep(100L)
        }
        launch(CommonPool) {
            Log.d(HttpExamples.TAG, "E")
            Thread.sleep(100L)
        }
        Log.d(HttpExamples.TAG,"Coroutines launched!")
    }

    fun nonBlocking() {
        Log.d(HttpExamples.TAG,"Launching non-blocking coroutines...")
        launch(CommonPool) {
            Log.d(HttpExamples.TAG, "A")
            delay(100L)
        }
        launch(CommonPool) {
            Log.d(HttpExamples.TAG, "B")
            delay(100L)
        }
        launch(CommonPool) {
            Log.d(HttpExamples.TAG, "C")
            delay(100L)
        }
        launch(CommonPool) {
            Log.d(HttpExamples.TAG, "D")
            delay(100L)
        }
        launch(CommonPool) {
            Log.d(HttpExamples.TAG, "E")
            delay(100L)
        }
        Log.d(HttpExamples.TAG,"Coroutines launched!")
    }
}
