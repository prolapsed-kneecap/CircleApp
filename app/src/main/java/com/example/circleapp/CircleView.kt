package com.example.circleapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CircleView(context : Context?, attributeSet: AttributeSet) : View(context, attributeSet){

    private val paint = Paint()

    private var circles = mutableListOf<Pair<Float, Float>>(
    )

    fun addCircle(givenCircle : Pair<Float, Float>){
        circles.add(givenCircle)
    }
    fun setCircles(givenCircles : MutableList<Pair<Float, Float>>){
        circles = givenCircles
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawColor(Color.WHITE)

        paint.color = Color.BLACK

        circles.forEach {
            canvas?.drawCircle(it.first, it.second, 100f, paint)
        }
    }
}