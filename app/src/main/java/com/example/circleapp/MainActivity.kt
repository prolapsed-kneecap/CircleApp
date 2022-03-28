package com.example.circleapp

import SameMaster
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.allViews

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val game = MainGame()

        val sameGridView = SameMaster().fieldSetUp  (SameGridView(this))
        setContentView(sameGridView)


//        sameView.setOnClickListener { sameView ->
//            sameView as SameView
//            if (sameView.isOpened) {
////                            sameView.close()
//            } else if (sameGridView.opened[0] == -1) {
//                sameView.open()
////                        sameGridView.opened[0] = sameView.svId
//            } else if (sameGridView.opened[1] == -1) {
//                sameView.open()
////                        sameGridView.opened[1] = sameView.svId
//                Toast.makeText(
//                    this@MainActivity,
//                    sameGridView.opened.toString(),
//                    Toast.LENGTH_SHORT
//                ).show()
//                if (sameGridView.opened[0] == sameGridView.opened[1]) {
//                    c = 0
//                    sameGridView.allViews.forEach {
//                        if (c != 0) {
//                            it as SameView
////                                    if (it.svId == sameGridView.opened[0]) {
////                                        it.isDone = true
////                                        it.setColorFilter(Color.GRAY)
////                                    }
//                        }
//                        Log.d("AAA", it.toString())
//                        c++
//                    }
//                    sameGridView.opened = MutableList(2) { -1 }
//                } else {
//                    var c = 0
//                    sameGridView.allViews.forEach {
//                        if (c != 0) {
//                            it as SameView
//                            if (it.isOpened) {
//                                object : CountDownTimer(1250, 1000) {
//                                    override fun onTick(p0: Long) {
//
//                                    }
//
//                                    override fun onFinish() {
////                                                if (it.isDone.not()) {
////                                                    it.close(sameGridView)
////                                                }
//                                    }
//
//                                }.start()
//                            }
//                        }
//                        c++
//                    }
//                    sameGridView.opened = MutableList(2) { -1 }
//                }
//            }
//            c++
//        }


        /*for (i in field) {
            for (j in i) {
                val sameView = SameView(this, j, c)
                sameView.svId = j
                sameView.setOnClickListener { sameView ->
                    sameView as SameView
                    if (sameView.isOpened) {
//                            sameView.close()
                    } else if (sameGridView.opened[0] == -1) {
                        sameView.open(sameGridView)
                        sameGridView.opened[0] = sameView.svId
                    } else if (sameGridView.opened[1] == -1) {
                        sameView.open(sameGridView)
                        sameGridView.opened[1] = sameView.svId
                        Toast.makeText(
                            this@MainActivity,
                            sameGridView.opened.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                        if (sameGridView.opened[0] == sameGridView.opened[1]) {
                            c = 0
                            sameGridView.allViews.forEach {
                                if (c != 0) {
                                    it as SameView
                                    if (it.svId == sameGridView.opened[0]) {
                                        it.isDone = true
                                        it.setColorFilter(Color.GRAY)
                                    }
                                }
                                Log.d("AAA", it.toString())
                                c++
                            }
                            sameGridView.opened = MutableList(2) { -1 }
                        } else {
                            var c = 0
                            sameGridView.allViews.forEach {
                                if (c != 0) {
                                    it as SameView
                                    if (it.isOpened) {
                                        object : CountDownTimer(1250, 1000) {
                                            override fun onTick(p0: Long) {

                                            }

                                            override fun onFinish() {
                                                if (it.isDone.not()) {
                                                    it.close(sameGridView)
                                                }
                                            }

                                        }.start()
                                    }
                                }
                                c++
                            }
                            sameGridView.opened = MutableList(2) { -1 }
                        }
                    }
                    c++
                }
                sameGridView.addView(sameView)
            }
        }*/

//        var opened = true
//
//        val sameView = findViewById<SameView>(R.id.sameView)
//
//        sameView.setOnClickListener {
//            if (opened) {
//                sameView.close()
//            } else {
//                sameView.open()
//            }
//            opened = opened.not()
//        }

//        val circleView = findViewById<CircleView>(R.id.circleView)
//        circleView.setCircles(mutableListOf(
//            Pair(200f, 200f), Pair(700f, 600f), Pair(500f, 400f)
//        ))
//
//        val button = findViewById<Button>(R.id.button)
//        button.setOnClickListener {
//            val min = 100f
//            val max = 900f
//            val r = Random()
//
//            val circles = mutableListOf<Pair<Float, Float>>(
//                Pair(min + r.nextFloat() * (max - min), min + r.nextFloat() * (max - min)),
//                Pair(min + r.nextFloat() * (max - min), min + r.nextFloat() * (max - min)),
//                Pair(min + r.nextFloat() * (max - min), min + r.nextFloat() * (max - min))
//            )
//            circleView.setCircles(circles)
//            circleView.invalidate()
//        }

    }
}