package com.example.rxjavaexample

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.random.Random
import kotlin.random.nextInt

fun observableString1(): Observable<Int> {
    return Observable.just(0, 1, 2, 3, 4)
}

fun observableString2() =
    Observable.just(5, 6, 7, 8, 9)

fun observableSlow10(sleepMs:Long,): Observable<Int> {
    val array = arrayListOf(10, 11, 12, 13, 14, 15)
    return Observable.create<Int> { emitter ->
        array.forEach { value ->
            Thread.sleep(sleepMs)
            emitter.onNext(value)
        }
        emitter.onComplete()
    }.subscribeOn(Schedulers.computation())
}

fun observableSlow20(sleepMs:Long,): Observable<Int> {
    val array = arrayListOf(20, 21, 22, 23, 24, 25)
    return Observable.create<Int> { emitter ->
        array.forEach { value ->
            Thread.sleep(sleepMs)
            emitter.onNext(value)
        }
    }.subscribeOn(Schedulers.computation())
}

fun observableRequest(paramRequest:Int) =
    Observable.create<String> {
        val waiting = Random.nextLong(1000,5000)
        Thread.sleep(waiting)
        it.onNext("$paramRequest waiting: $waiting value: ${Random.nextInt(1..10)}")
        //  it.onComplete()
    }