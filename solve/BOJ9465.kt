import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().toInt()

    for (i in 1..tc) {
        val n = br.readLine().toInt()

        val up = Array(n) {0}
        val down = Array(n) {0}

        val arr = Array(2) { IntArray(n) { 0 } }

        var st = StringTokenizer(br.readLine())

        for (i in 0 until n) {
            arr[0][i] = st.nextToken().toInt()
        }

        st = StringTokenizer(br.readLine())

        for (i in 0 until n) {
            arr[1][i] = st.nextToken().toInt()
        }

        up[0] = arr[0][0]
        down[0] = arr[1][0]

        for(i in 1 until n) {
            up[i] = down[i - 1] + arr[0][i]
            down[i] = up[i - 1] + arr[1][i]

            if(i > 1) {
                up[i] = up[i].coerceAtLeast(down[i - 2] + arr[0][i])
                down[i] = down[i].coerceAtLeast(up[i - 2] + arr[1][i])
            }
        }
        println(up[n - 1].coerceAtLeast(down[n  - 1]))
    }
}