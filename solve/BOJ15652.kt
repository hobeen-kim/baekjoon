import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.StringTokenizer

val arr1 = mutableListOf<List<Int>>()
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    for (i in 1..n) {
        cal1(i, n, m - 1, listOf(i))
    }


    val sb = StringBuilder()

    arr1.forEach { it -> it.forEach {
        sb.append(it).append(' ')
    }
        sb.append('\n')
    }

    bw.write(sb.toString())

    bw.close()
    br.close()
}

fun cal1(start: Int, end: Int, depth: Int, list: List<Int>) {

    if(depth == 0) {
        arr1.add(list)
        return
    }

    for (i in start..end) {

        var newList = list.toMutableList()
        newList.add(i)

        cal1(i, end, depth - 1, newList)
    }
}