package day2

import java.io.File

fun main(args: Array<String>) {
    var sum = 0
    val digits = mapOf(
        "zero" to 0, "one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9,
        "0" to 0, "1" to 1, "2" to 2, "3" to 3, "4" to 4, "5" to 5, "6" to 6, "7" to 7, "8" to 8, "9" to 9
    )
    File( "data/day1.txt").absoluteFile.forEachLine { line ->
        val first = line.findAnyOf(digits.keys, 0, true)?.second
        val last = line.findLastAnyOf(digits.keys, line.length, true)?.second
        sum += ("" + digits[first] + digits[last]).toInt()
    }
    println(sum)
}