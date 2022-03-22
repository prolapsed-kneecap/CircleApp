package com.example.circleapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import androidx.appcompat.widget.AppCompatImageView
import kotlinx.coroutines.*

class SameView(context: Context) : AppCompatImageView(context) {

    var state: SameViewState = SameViewState.CLOSED
//    var isOpened = false
    var openedDrawable = R.drawable.cloudsun
    var svId = -1

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (svId != -1){
            openedDrawable = Data.drawableMap[svId]!!
        }
        when (state) {
            SameViewState.CLOSED -> {
                setImageResource(R.drawable.back)
            }
            SameViewState.OPENED -> {
                setImageResource(openedDrawable)
            }
            SameViewState.DONE -> {
                setImageResource(openedDrawable)
                setColorFilter(R.color.tint)
            }
        }
//        if (isOpened) {
//            setImageResource(openedDrawable)
//        } else {
//            setImageResource(R.drawable.back)
//        }
    }

    fun open() {
        // if (gridView.opened[0] == -1 || gridView.opened[1] == -1) {
        state = SameViewState.OPENED
        GlobalScope.launch {
            for (i in 0..180) {
                delay(1)
                rotationY = i.toFloat()
                if (i == 90) {
                    setImageResource(openedDrawable)
                }
            }
        }
        // }
    }

    fun close() {
        state = SameViewState.CLOSED
        GlobalScope.launch {
            for (i in 180 downTo 0) {
                delay(1)
                rotationY = i.toFloat()
                if (i == 90) {
                    setImageResource(R.drawable.back)
                }
            }
        }
    }

}

