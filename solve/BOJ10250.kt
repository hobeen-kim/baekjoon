import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class BOJ10250 {
}

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))

    var tc: Int = Integer.parseInt(br.readLine())


    for (i in 1..tc) {
        var st = StringTokenizer(br.readLine())

        var h = Integer.parseInt(st.nextToken())
        var w = Integer.parseInt(st.nextToken())
        var order = Integer.parseInt(st.nextToken())

        var floor = order % h
        floor = if(floor == 0) h else floor
        var address = (order - 1) / h + 1

        if(address >= 10) {
            println(floor.toString() + address.toString())
        }else {
            println(floor.toString() + "0" + address.toString())
        }
    }
}