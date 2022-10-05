package com.example.rxjavaexample.examples

import android.util.Log
import com.example.rxjavaexample.observableString1
import com.example.rxjavaexample.observableString2
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


fun example1() {
    val disposable = observableString1().mergeWith(observableString2())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnNext { Log.d("XXXX-1", it.toString()) }
        //  .mergeWith(observableString2())
        .doOnNext { Log.d("XXXX-2", it.toString()) }

        //      .switchMap { // }concatMap {

        //      observableRequest(it)
        //  .subscribeOn(Schedulers.io())
        //     }

        .subscribe {
            Log.d("XXX", it.toString())
            // Log.d("XXX",it.toString())
        }
}