package com.example.nilzor.coroutines

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Corot.blockingThreads()
    }

    fun button1(v: View) {
        Corot.nonBlocking()
    }

    fun button2(v: View) {
        Corot.blockingThreads()
    }

    fun button3(v: View) {
        Corot.execHttpRetrofitPlain()
    }

    fun button4(v: View) {
        Corot.execHttpWithRxSingle()
    }

    fun button5(v: View) {
        Corot.execHttpWithRxSingleWrapped()
    }

}
