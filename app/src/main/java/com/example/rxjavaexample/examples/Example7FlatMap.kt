package com.example.rxjavaexample.examples

import android.util.Log
import com.example.rxjavaexample.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction


fun example7FlatMap() {
    val observer = observableInterval1000()
        .concatMap {
            observableRequest(it)
        }.subscribe {
            Log.d("XXX", it.toString())
        }
}