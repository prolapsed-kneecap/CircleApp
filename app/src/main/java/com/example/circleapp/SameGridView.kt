package com.example.circleapp

import android.content.Context
import android.widget.GridLayout
import androidx.core.view.allViews
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SameGridView(context: Context) : GridLayout(context) {
    var opened = MutableList(2) { -1 }
//    val state : SameGridState = SameGridState.ALIVE


//    fun clickOnChild(x: Int, y: Int) {
//
//    }

//    private val clickOnChild : (x: Int, y: Int, sameView: SameView) -> Unit =

    fun fill(width: Int, height: Int, field : List<List<Int>> = listOf(listOf())) {
        val f = field.isNotEmpty()
        for (i in 0 until height) {
            for (j in 0 until width) {
                addView(SameView(context).apply {
                    if (f) {
                        svId = field[i][j]
                    }
                })
            }
        }
    }

    fun open(i: Int, j: Int) {
        var c = 0
        allViews.forEach {
            it as SameView
            if (c == i * Data.n + j) {
                if (opened[0] == -1 || opened[1] == -1) {
                    it.state = SameViewState.OPENED
                    GlobalScope.launch {
                        for (i in 0..180) {
                            delay(1)
                            rotationY = i.toFloat()
                            if (i == 90) {
                                it.setImageResource(Data.drawableMap[0]!!)
                            }
                        }
                    }
                }
            }
            c++
        }
    }

    fun close(i: Int, j: Int) {
        var c = 0
        allViews.forEach {
            it as SameView
            if (c == i * Data.n + j) {
                it.state = SameViewState.CLOSED
                GlobalScope.launch {
                    for (i in 180 downTo 0) {
                        delay(1)
                        rotationY = i.toFloat()
                        if (i == 90) {
                            it.setImageResource(R.drawable.back)
                        }
                    }
                }
            }
            c++
        }
    }

    fun setOnChildClickListener(listener: (Int, Int, SameView) -> Unit) {
        allViews
            .toList()
            .chunked(columnCount)
            .forEachIndexed { indexY, row ->
                row.forEachIndexed { indexX, elem ->
                    elem.setOnClickListener {
                        if (indexX != 0 || indexY != 0) {
                            listener(indexY, indexX, it as SameView)
                        }
                    }
                }
        }
    }

//    val mStateFlow : MutableStateFlow<State> = MutableStateFlow(State.NoOpened())
}