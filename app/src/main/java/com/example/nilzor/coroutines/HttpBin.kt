package com.example.nilzor.coroutines

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable


interface HttpBin {
    companion object {
        val instance: HttpBin = createInstance()
        private fun createInstance(): HttpBin {
            return Retrofit.Builder().baseUrl("http://httpbin.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build().create(HttpBin::class.java)
        }
    }

    @GET("delay/{secs}")
    fun delay(@Path("secs") delayTimeSecs: Int): Observable<HttpBinReply>
    @GET("delay/{secs}")
    fun delay2(@Path("secs") delayTimeSecs: Int): Call<HttpBinReply>
}