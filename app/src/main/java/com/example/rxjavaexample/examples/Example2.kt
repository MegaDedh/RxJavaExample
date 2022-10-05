package com.example.rxjavaexample.examples

import android.util.Log
import com.example.rxjavaexample.observableSlow10
import com.example.rxjavaexample.observableSlow20
import io.reactivex.rxjava3.core.Observable


fun example2() {


   val obser =  Observable.merge(observableSlow10(1000),observableSlow20(500))
       .subscribe {
           Log.d("XXX", it.toString())
       }

//    val disposable = observableSlow(2000)
//        . mergeWith(observableSlow(1000))
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//
//        .doOnNext { Log.d("XXXX-1", it.toString()) }
//        //  .mergeWith(observableString2())
//        .doOnNext { Log.d("XXXX-2", it.toString()) }
//
//        //      .switchMap { // }concatMap {
//
//        //      observableRequest(it)
//        //  .subscribeOn(Schedulers.io())
//        //     }
//
//        .subscribe {
//            Log.d("XXX", it.toString())
//            // Log.d("XXX",it.toString())
//        }

}