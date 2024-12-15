package day_03_mull_it_over

import java.io.File

class MullItOver {


}

fun main() {
    val INPUT_FILE_NAME = "src/day_03_mull_it_over/input_data.txt"
//    val INPUT_FILE_NAME = "src/day_03_mull_it_over/test_data.txt"
    solve(INPUT_FILE_NAME)
}

fun solve(file: String) {
    val inputStream = File(file).inputStream()
    var output = 0
    inputStream.bufferedReader().forEachLine { line ->
        output += getLineValue(line)
    }
    println("Solution output = $output")
}

fun getLineValue(line: String): Int {
    val matches = getMatches(line)
    var lineValue = 0
    for (match in matches) {
        lineValue += parseMatchValue(match)
    }
    return lineValue
}

fun getMatches(string: String): List<String> {
    val regex = Regex("mul\\(\\d+,\\d+\\)")
    return regex.findAll(string).map { it.value }.toList()
}

fun parseMatchValue(string: String): Int {
    // in form "mul(a,b)"
    val parts = string.substring(4, string.length-1).split(',')
    return mul(parts[0].toInt(), parts[1].toInt())
}

fun mul(a: Int, b: Int) = a * b