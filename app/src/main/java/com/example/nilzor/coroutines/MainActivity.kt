package com.example.nilzor.coroutines

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PatternExamples.blockingThreads()
    }

    fun button1(v: View) {
        PatternExamples.nonBlocking()
    }

    fun button2(v: View) {
        PatternExamples.blockingThreads()
    }

    fun button3(v: View) {
        HttpExamples.execHttpRetrofitPlain()
    }

    fun button4(v: View) {
        HttpExamples.execHttpWithRxSingle()
    }

    fun button5(v: View) {
        HttpExamples.execHttpWithRxSingleWrapped()
    }

}
