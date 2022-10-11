package com.example.rxjavaexample

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import kotlin.random.Random
import kotlin.random.nextInt

fun observableGetName(sleepMs: Long): Observable<String> {
    val array = arrayListOf("FirstName1", "FirstName2", "FirstName3", "FirstName4", "FirstName5")
    return Observable.create { emitter ->
        array.forEach { value ->
        //    Thread.sleep(sleepMs)
            emitter.onNext(value)
        }
    }
        .subscribeOn(Schedulers.io())
}

fun observableGetSecondName(sleepMs: Long): Observable<String> {
    val array = arrayListOf("SecondName1", "SecondName2", "SecondName3", "SecondName4", "SecondName5")
    return Observable.create { emitter ->
        array.forEach { value ->
//            Thread.sleep(sleepMs)
            emitter.onNext(value)
        }
    }.subscribeOn(Schedulers.io())
}

fun observableGetAge(sleepMs: Long): Observable<Int> {
    val array = arrayListOf(10, 20, 30, 40, 50)
    return Observable.create { emitter ->
        array.forEach { value ->
//            Thread.sleep(sleepMs)
            emitter.onNext(value)
        }
    }.subscribeOn(Schedulers.io())
}