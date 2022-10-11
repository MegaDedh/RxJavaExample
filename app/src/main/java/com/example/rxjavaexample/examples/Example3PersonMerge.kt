package com.example.rxjavaexample.examples

import android.util.Log
import com.example.rxjavaexample.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers


fun example3PersonMerge() {

    val observer = Observable.mergeDelayError(
        observableGetName(100),
        observableGetSecondName(500),
        observableGetAge(1000).map {
            it.toString()
        })
        .doOnNext {

        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                Log.d("XXX", it.toString())
            }
}