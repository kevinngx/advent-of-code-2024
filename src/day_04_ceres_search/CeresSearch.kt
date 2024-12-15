package day_04_ceres_search

import InputReader

class solution {

}

fun main() {
    val input = InputReader.readInput("src/day_04_ceres_search/input_data.txt")

   // for (line in input) {
   //     println("$line")
   // }

    val numLines = input.size
    val lineLength = input.first().length

    for (row in 0 until numLines) {
        for (col in 0 until lineLength) {
            println("row: $row, col: $col --> ${input[row][col]}")
            searchAtIndex(row, col, input)
        }
        println("")
    }
}

fun searchAtIndex(row: Int, col: Int, input: Array<String>) {

}
