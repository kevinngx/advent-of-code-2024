package day_01_historian_hysteria

import java.io.File
import kotlin.math.abs

fun main() {
    val INPUT_FILE_NAME = "src/day-01-historian-hysteria/input_data.txt"
    // val INPUT_FILE_NAME = "src/day-01-historian-hysteria/test_data.txt"
    listDistance(INPUT_FILE_NAME)
    listSimilarity(INPUT_FILE_NAME)
}

fun listDistance(filename: String) {
    val inputStream = File(filename).inputStream()
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
    println("List distance is $runningDiff")
}

fun listSimilarity(filename: String) {
    val inputStream = File(filename).inputStream()
    val mapA = mutableMapOf<Int, Int>()
    val mapB = mutableMapOf<Int, Int>() //: HashMap<Int, Int>
    inputStream.bufferedReader().useLines { lines ->
        lines.forEach { line ->
            val lineElems = line.split("   ")
            val a = lineElems[0].toInt()
            val b = lineElems[1].toInt()

            if (mapA.containsKey(a)) {
                mapA[a] = mapA[a]!! + 1
            } else {
                mapA[a] = 1
            }
            if (mapB.containsKey(b)) {
                mapB[b] = mapB[b]!! + 1
            } else {
                mapB[b] = 1
            }
        }
    }
    var similarity = 0
    for (item in mapA) {
        similarity += item.key * item.value * ( if (mapB.contains(item.key)) mapB[item.key]!! else 0)
    }
    println("List similarity is $similarity")
}
