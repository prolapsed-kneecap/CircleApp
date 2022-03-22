import com.example.circleapp.SameGridView

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

    fun mathes(x: Int, y: Int) = x == y
}