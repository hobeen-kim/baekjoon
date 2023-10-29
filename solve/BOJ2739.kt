import java.util.Scanner

class BOJ2739 {
}

fun main() {
    var sc = Scanner(System.`in`)

    var n = sc.nextInt()

    for (i in 1..9) {
        println("$n * $i = ${i * n}")
    }
}