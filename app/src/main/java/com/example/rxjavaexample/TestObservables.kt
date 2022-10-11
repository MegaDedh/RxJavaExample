package com.example.rxjavaexample

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import kotlin.random.Random
import kotlin.random.nextInt

fun observableString1(): Observable<Int> {
    return Observable.just(0, 1, 2, 3, 4)
}

fun observableString2() =
    Observable.just(5, 6, 7, 8, 9)

//Бесконечно эмитит Long++ через заданный интервал времени
fun observableInterval250(): Observable<Long> = Observable.interval(250, TimeUnit.MILLISECONDS)
fun observableInterval1000(): Observable<Long> = Observable.interval(1000, TimeUnit.MILLISECONDS)


fun observableSlow10(sleepMs: Long): Observable<Int> {
    val array = arrayListOf(10, 11, 12, 13, 14, 15)
    return Observable.create<Int> { emitter ->
        array.forEach { value ->
            Thread.sleep(sleepMs)
            emitter.onNext(value)
        }
        emitter.onComplete()
    }.subscribeOn(Schedulers.computation())
}

fun observableSlow20(sleepMs: Long): Observable<Int> {
    val array = arrayListOf(20, 21, 22, 23, 24, 25)
    return Observable.create<Int> { emitter ->
        array.forEach { value ->
            Thread.sleep(sleepMs)
            emitter.onNext(value)
        }
    }.subscribeOn(Schedulers.computation())
}

fun observableRequest(paramRequest:Long): Observable<String> {
    val waiting = Random.nextLong(5000)
    return Observable.create<String> {
        it.onNext("$paramRequest waiting: $waiting value: ${Random.nextInt(1..10)}")
        it.onComplete()
    }.doOnSubscribe { Log.d("XXX", "observableRequest onSubscribe") }
        .subscribeOn(Schedulers.io())
        .delay(waiting, TimeUnit.MILLISECONDS)
}