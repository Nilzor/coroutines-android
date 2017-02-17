package com.example.nilzor.coroutines

import android.util.Log
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import rx.schedulers.Schedulers
import java.util.concurrent.ForkJoinPool

object Corot {
    val TAG = "Demo";

    fun execHttp() {
        HttpBin.instance.delay(1).subscribeOn(Schedulers.io()).subscribe({
            Log.d(TAG, "Got origin: " + it.origin)
        })


      //  HttpBin.instance().delay2(1).execute();
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