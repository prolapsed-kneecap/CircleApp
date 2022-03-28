package com.example.circleapp

import SameMaster

class MainGame {
    private val master = SameMaster()
    var opened = MutableList(2) { -1 }
    val idField = setRandomGameField(Data.n, Data.m)
    val stateField = MutableList(Data.n * Data.m) { 0 }
    fun open(ind: Int) {
        stateField[ind - 1] = 1
    }

    fun close(ind: Int) {
        stateField[ind - 1] = 0
    }

    fun done(ind: Int) {
        stateField[ind - 1] = -1
    }

    private fun setRandomGameField(n: Int, m: Int): List<Int> {
//        var field = listOf<List<Int>>()

        var mList = MutableList(n * m) { c -> c - (c % 2) }.shuffled()

//        field = mList.shuffled().chunked(m)

        return mList
    }

    fun checkIfDone(stateField: List<Int>): Boolean =
        (stateField.isNotEmpty()) && stateField.all { it == -1 }

}