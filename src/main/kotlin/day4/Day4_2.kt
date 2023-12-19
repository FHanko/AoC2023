package day4

import java.io.File

fun main(args: Array<String>) {
    var copiesMap = mutableMapOf<Int, Int>()
    File( "data/day4.txt").absoluteFile.forEachLine { line ->
        val splits = line.split(':','|').map { it.trim() }
        val id = splits[0].split(' ').last().toInt()
        copiesMap[id] = (copiesMap[id] ?: 0) + 1
        val winning = splits[1].split(' ').filter { it != "" }
        val numbers = splits[2].split(' ')
        val matching = numbers.intersect(winning)

        for (i in id + 1 .. (id + matching.count())) {
            copiesMap[i] = (copiesMap[i] ?: 0) + copiesMap[id]!!
        }
    }
    println(copiesMap.values.sum())
}