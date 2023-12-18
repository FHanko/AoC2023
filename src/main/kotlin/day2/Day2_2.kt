package day2

import java.io.File
import kotlin.math.max

fun main(args: Array<String>) {
    var sum = 0
    File( "data/day2.txt").absoluteFile.forEachLine { line ->
        val id = line.split(':').first().split(' ').last()
        val cubes = line.split(':').last()
        val cubeMax = mutableMapOf("red" to 0, "green" to 0, "blue" to 0)
        cubes.split(',', ';').forEach {
            val split = it.trim()
            val color = split.split(' ').last()
            val amount = split.split(' ').first()
            cubeMax[color] = max(amount.toInt(), cubeMax.getValue(color))
        }
        sum += cubeMax.getValue("red") * cubeMax.getValue("green") * cubeMax.getValue("blue")
        println("$id $cubeMax")
    }
    println(sum)
}