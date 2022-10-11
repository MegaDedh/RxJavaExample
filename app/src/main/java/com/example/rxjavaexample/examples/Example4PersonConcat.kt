package com.example.rxjavaexample.examples

import android.util.Log
import com.example.rxjavaexample.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers


fun example4PersonConcat() {

    val observer =
        observableGetName(100)
            .concatWith(observableGetSecondName(500))
            .concatWith(observableGetAge(1000).map {
                it.toString()
            })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                Log.d("XXX", it.toString())
            }
}