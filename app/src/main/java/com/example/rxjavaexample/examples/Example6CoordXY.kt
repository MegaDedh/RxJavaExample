package com.example.rxjavaexample.examples

import android.util.Log
import com.example.rxjavaexample.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction


fun example6CoordXY() {
    val observer = Observable.combineLatest(
        observableInterval250(),
        observableInterval1000())
        { x,y -> CoordXY(x, y) }
        .subscribe {
            Log.d("XXX", it.toString())
        }
}

data class CoordXY(val x: Long, val y: Long)