package day1

import java.io.File

fun main(args: Array<String>) {
    var sum = 0
    File( "data/day1.txt").absoluteFile.forEachLine { line ->
        val first = line.first { it.isDigit() }
        val last = line.last { it.isDigit() }
        sum += ("" + first + last).toInt()
    }
    println(sum)
}