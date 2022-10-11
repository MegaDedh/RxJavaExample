package com.example.rxjavaexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rxjavaexample.examples.*


class MainActivity : AppCompatActivity() {
    companion object {
        const val NUM_LAUNCH = 7
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
            3 -> example3PersonMerge()
            4 -> example4PersonConcat()
            5 -> example5PersonZip()
            6 -> example6CoordXY()
            7 -> example7FlatMap()
            else ->{
                // TODO("Test code quickly")
            }
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