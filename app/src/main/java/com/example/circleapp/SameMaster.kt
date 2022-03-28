import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.core.view.allViews
import com.example.circleapp.*

class SameMaster() {

    fun fieldSetUp(sameGridView: SameGridView): SameGridView {

        val mainGame = MainGame()

        mainGame.opened = MutableList(2) { -1 }
        sameGridView.removeAllViews()
        val n = Data.n
        val m = Data.m
        sameGridView.rowCount = n
        sameGridView.columnCount = m

        sameGridView.fill(m * n, mainGame.idField)

        sameGridView.setOnChildClickListener { ind, view ->
            if (view.state == SameViewState.CLOSED) {
                if (mainGame.opened[0] == -1) {
                    mainGame.opened[0] = view.svId
                    view.open()
                    mainGame.open(ind - 1)
                } else if (sameGridView.opened[1] == -1) {
                    mainGame.opened[1] = view.svId
                    view.open()
                    mainGame.open(ind - 1)
                    if (mainGame.opened[0] == mainGame.opened[1]) {
                        sameGridView.allViews.forEachIndexed { i: Int, view: View ->
                            if (i != 0) {
                                view as SameView
                                if (view.svId == mainGame.opened[0]) {
                                    view.state = SameViewState.DONE
                                    mainGame.done(ind - 1)
                                    view.invalidate()
                                    if (mainGame.checkIfDone(mainGame.idField))  {
                                        fieldSetUp(sameGridView)
                                    }
                                }
                            }
                        }
                        mainGame.opened = MutableList(2) { -1 }
                    } else {

                        object : CountDownTimer(1000, 1000) {
                            override fun onTick(p0: Long) {
                            }

                            override fun onFinish() {
                                sameGridView.allViews.forEachIndexed { i: Int, view: View ->
                                    if (i != 0) {
                                        view as SameView
                                        if (view.state == SameViewState.OPENED) {
                                            view.state = SameViewState.CLOSED
                                            view.close()
                                            mainGame.close(ind - 1)
                                        }
                                    }
                                }
                                mainGame.opened = MutableList(2) { -1 }
                            }
                        }.start()
                    }
                }
            }
        }
        return sameGridView
    }
}