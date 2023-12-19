package day4

import java.io.File

fun main(args: Array<String>) {
    var sum = 0
    File( "data/day4.txt").absoluteFile.forEachLine { line ->
        val splits = line.split(':','|').map { it.trim() }
        val winning = splits[1].split(' ').filter { it != "" }
        val numbers = splits[2].split(' ')
        val matching = numbers.intersect(winning)
        val points = if (matching.isNotEmpty()) Math.pow(2.0, 0.0 + matching.count()-1) else 0
        sum += points.toInt()
    }
    println(sum)
}