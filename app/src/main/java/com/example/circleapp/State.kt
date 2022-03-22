package com.example.circleapp

sealed class State(
    val pair: Pair<Int, Int>? = null,
    val one: Int? = null
) {
    class TwoOpened(pair: Pair<Int, Int>) : State(pair)
    class OneOpenedding(pair: Pair<Int, Int>? = null, one: Int) : State(null, one)
    class NoOpened(pair: Pair<Int, Int>? = null, one: Int? = null) : State(pair, one)
}