package com.example.circleapp

import android.util.Log
import org.junit.Test

class MainGameTest() {
    @Test
    fun checkOpen() {
        val mainGame = MainGame()
        val ind = 3
        mainGame.open(ind)
        print(mainGame.stateField.toString())
        assert(mainGame.stateField[ind] == 1)
    }
    @Test
    fun checkClose() {
        val mainGame = MainGame()
        val ind = 3
        mainGame.close(ind)
        print(mainGame.stateField.toString())
        assert(mainGame.stateField[ind] == 0)
    }
    @Test
    fun checkDone() {
        val mainGame = MainGame()
        val ind = 3
        mainGame.done(ind)
        print(mainGame.stateField.toString())
        assert(mainGame.stateField[ind] == -1)
    }
}