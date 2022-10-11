package com.example.rxjavaexample.examples

import android.util.Log
import com.example.rxjavaexample.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


fun example5PersonZip() {
    val observer =
        observableGetName(100)
            .zipWith(observableGetSecondName(500), ({ name, secondName -> name + secondName }) )
            .zipWith(observableGetAge(1000).map { it.toString() }, ({fullName, age -> fullName + age}))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                Log.d("XXX", it.toString())
            }
}