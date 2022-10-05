package com.example.rxjavaexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.rxjavaexample.examples.example1
import com.example.rxjavaexample.examples.example2
import io.reactivex.rxjava3.core.Observable


class MainActivity : AppCompatActivity() {
    companion object {
        const val NUM_LAUNCH = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        when (NUM_LAUNCH) {
            1 -> example1()
            2 -> example2()
        }


//
//
//        val gfgList: Observable<String> = Observable.fromArray("DSA", "Py", "Android", "Java")
//        val gfgListTwo: Observable<String> = Observable.fromArray("Intern", "FullTime", "PartTime")
//
//        Observable.merge(gfgList, gfgListTwo).subscribe {
//            Log.d("XXX", it.toString())
//        }
//


    }
}