package com.example.nilzor.coroutines

import android.util.Log
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.rx.awaitSingle
import kotlinx.coroutines.experimental.rx.rxSingle
import rx.schedulers.Schedulers
import java.util.concurrent.ForkJoinPool

object Corot {
    val TAG = "Demo";
    fun execHttpRetrofitPlain() {
        HttpBin.instance.delay(1).subscribeOn(Schedulers.io()).subscribe({
            Log.d(TAG, "Got origin: " + it.origin)
        })
    }

    fun execHttpWithRxSingle() {
        rxSingle {
            try {
                val something = HttpBin.instance.delay(1).awaitSingle()
                Log.d(TAG, "Got origin from execRxSignle: " + something.origin)
            } catch (e: Exception) {
                Log.e(TAG, "ERR", e)
            }
        }
    }

    fun execHttpWithRxSingleWrapped() {
        launch(CommonPool) {
            execHttpWithRxSingle()
        }
    }

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
        Log.d(TAG,"Launching blocking coroutines... CommonPool thread count: " + pool.parallelism  )
        launch(CommonPool) {
            Log.d(TAG, "A")
            Thread.sleep(100L)
        }
        launch(CommonPool) {
            Log.d(TAG, "B")
            Thread.sleep(100L)
        }
        launch(CommonPool) {
            Log.d(TAG, "C")
            Thread.sleep(100L)
        }
        launch(CommonPool) {
            Log.d(TAG, "D")
            Thread.sleep(100L)
        }
        launch(CommonPool) {
            Log.d(TAG, "E")
            Thread.sleep(100L)
        }
        Log.d(TAG,"Coroutines launched!")
    }

    fun nonBlocking() {
        Log.d(TAG,"Launching non-blocking coroutines...")
        launch(CommonPool) {
            Log.d(TAG, "A")
            delay(100L)
        }
        launch(CommonPool) {
            Log.d(TAG, "B")
            delay(100L)
        }
        launch(CommonPool) {
            Log.d(TAG, "C")
            delay(100L)
        }
        launch(CommonPool) {
            Log.d(TAG, "D")
            delay(100L)
        }
        launch(CommonPool) {
            Log.d(TAG, "E")
            delay(100L)
        }
        Log.d(TAG,"Coroutines launched!")
    }
}