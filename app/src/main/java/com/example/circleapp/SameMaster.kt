import android.content.Context
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.allViews
import com.example.circleapp.Data
import com.example.circleapp.SameGridView
import com.example.circleapp.SameView
import com.example.circleapp.SameViewState

class SameMaster() {

    val coordsToSvId = mutableMapOf<Pair<Int, Int>, Int>(

    )

    fun getRandomField(n: Int, m: Int): List<List<Int>> {
        var field = listOf<List<Int>>()

        var mList = MutableList(n * m) { c -> c - (c % 2) }
//        var mList = MutableList(n*m){0}

        field = mList.shuffled().chunked(m)

        return field
    }

    fun checkIfDone(sameGridView: SameGridView): Boolean {
        sameGridView.allViews.forEachIndexed{ i, it ->
            if (i != 0) {
                it as SameView
                if (it.state == SameViewState.CLOSED || it.state == SameViewState.OPENED) {
                    return false
                }
            }
        }
        return true
    }

    fun mathes(x: Int, y: Int) = x == y

    fun fieldSetUp(sameGridView: SameGridView): SameGridView {

        sameGridView.opened = MutableList(2) {-1}
        sameGridView.removeAllViews()

        val n = Data.n
        val m = Data.m
        sameGridView.rowCount = n
        sameGridView.columnCount = m

        val field = getRandomField(n, m)

        sameGridView.fill(m, n, field)

        sameGridView.setOnChildClickListener { x, y, view ->
            if (view.state == SameViewState.CLOSED) {
                if (sameGridView.opened[0] == -1) {
                    Log.d("AAA", view.svId.toString())
                    sameGridView.opened[0] = view.svId
                    view.open()
                } else if (sameGridView.opened[1] == -1) {
                    sameGridView.opened[1] = view.svId
                    view.open()
                    if (mathes(sameGridView.opened[0], sameGridView.opened[1])) {
                        sameGridView.allViews.forEachIndexed { i: Int, view: View ->
                            if (i != 0) {
                                view as SameView
                                if (view.svId == sameGridView.opened[0]) {
                                    view.state = SameViewState.DONE
                                    view.invalidate()
                                    if (checkIfDone(sameGridView))  {
                                        fieldSetUp(sameGridView)
                                    }
                                }
                            }
                        }
                        sameGridView.opened = MutableList(2) { -1 }
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
                                        }
                                    }
                                }
                                sameGridView.opened = MutableList(2) { -1 }
                            }
                        }.start()
                    }
                }
            }
        }
        return sameGridView
    }
}