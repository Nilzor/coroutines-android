package com.example.nilzor.coroutines

import android.util.Log
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.rx.awaitSingle
import kotlinx.coroutines.experimental.rx.rxSingle
import rx.schedulers.Schedulers

object HttpExamples {
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
}