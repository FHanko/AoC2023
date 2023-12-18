package day3

import java.io.File
fun main(args: Array<String>) {
    var sum = 0
    val map = mutableMapOf<Pair<Int, Int>, Char>()
    var y = 0
    File( "data/day3.txt").absoluteFile.forEachLine { line ->
        line.forEachIndexed { x, c ->
            map[x to y] = c
        }
        y++
    }

    val added = mutableListOf<Pair<Int, Int>>()
    val adjacentCoords = listOf(-1 to -1, 0 to -1, 1 to -1, -1 to 0, 1 to 0, -1 to 1, 0 to 1, 1 to 1)
    map.forEach { (sxy, c) ->
        if (c == '*') {
            val adjParts = mutableListOf<Int>()
            adjacentCoords.forEach adj@{ axy ->
                val xy = sxy add axy
                val adjacent = map[xy] ?: return@adj
                if (adjacent.isDigit()) {
                    var offLeft = 0
                    while (map[xy add (-(offLeft + 1) to 0)]?.isDigit() == true) {
                        offLeft++
                    }

                    //check already added
                    if (added.contains(xy add (-offLeft to 0))) return@adj
                    added.add(xy add (-offLeft to 0))

                    var number = ""
                    var offRight = 0
                    while (map[xy add ((-offLeft + offRight) to 0)]?.isDigit() == true) {
                        number += map[xy add ((-offLeft + offRight) to 0)]
                        offRight++
                    }
                    println("$offLeft $offRight")
                    println(number)
                    adjParts.add(number.toInt())
                }
            }
            if (adjParts.count() == 2) {
                sum += adjParts[0] * adjParts[1]
            }
        }
    }
    println(sum)
}