package day_01_list_distance

import java.io.File
import kotlin.math.abs

fun main() {
    val INPUT_FILE_NAME = "src/day_01_list_distance/input_data.txt"
    // val INPUT_FILE_NAME = "src/day_01_list_distance/test_data.txt"
    val inputStream = File(INPUT_FILE_NAME).inputStream()
    val listA = mutableListOf<Int>()
    val listB = mutableListOf<Int>()
    inputStream.bufferedReader().useLines { lines ->
        lines.forEach { line ->
            listA.add(line.split("   ")[0].toInt())
            listB.add(line.split("   ")[1].toInt())
        }
    }
    listA.sort()
    listB.sort()
    var runningDiff = 0
    for (i in listA.indices) {
        runningDiff += abs(listA[i] - listB[i])
    }
    println("Answer is $runningDiff")
}

