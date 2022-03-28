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

    fun fill(size: Int, field: List<Int>) {
        if (field.isNotEmpty()) {
            for (i in 0 until size) {
                addView(SameView(context).apply {
                    svId = field[i]
                })
            }
        }
//        for (i in 0 until height) {
//            for (j in 0 until width) {
//                addView(SameView(context).apply {
//                    if (f) {
//                        svId = field[i][j]
//                    }
//                })
//            }
//        }
    }

    fun setOnChildClickListener(listener: (Int, SameView) -> Unit) {
        allViews.forEachIndexed { i, it ->
            if (i != 0) {
                it.setOnClickListener {
                    listener(i, it as SameView)
                }
            }
        }
//        allViews
//            .toList()
//            .chunked(columnCount)
//            .forEachIndexed { indexY, row ->
//                row.forEachIndexed { indexX, elem ->
//                    elem.setOnClickListener {
//                        if (indexX != 0 || indexY != 0) {
//                            listener(indexY, indexX, it as SameView)
//                        }
//                    }
//                }
//        }
    }

//    val mStateFlow : MutableStateFlow<State> = MutableStateFlow(State.NoOpened())
}