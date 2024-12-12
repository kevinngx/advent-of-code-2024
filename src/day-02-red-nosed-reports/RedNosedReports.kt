package `day-02-red-nosed-reports`

import java.io.File
import kotlin.math.abs

enum class direction(val value: Int) {
    INCREASING(1),
    DECREASING(-1),
    EQUAL(0)
}

fun main() {
        val INPUT_FILE_NAME = "src/day-02-red-nosed-reports/input_data.txt"
//         val INPUT_FILE_NAME = "src/day-02-red-nosed-reports/test_data.txt"

        val inputStream = File(INPUT_FILE_NAME).inputStream()
        var safeCount = 0
        var expectedDirection : direction

        inputStream.bufferedReader().forEachLine { line ->
            val nums = line.split(" ")
            if (nums.size < 2) {
                safeCount++
                return@forEachLine
            } else {
                expectedDirection = getDirection(nums[0].toInt(), nums[1].toInt())
            }

            var problemDampenerHasCharge = true
            var prev = nums[0].toInt()

            for (i in 1 until  nums.size) {
                val curr = nums[i].toInt()
                if (getDirection(prev, curr) != expectedDirection || abs(curr - prev) > 3) {
                    // Check three options:
                    // Remove previous

                    // Remove current

                    // Remove next

                    return@forEachLine
                }
                prev = curr
            }
            safeCount++
        }
    println("Safe Count is $safeCount")
}

fun getDirection(a: Int, b: Int): direction {
    return if (a < b) {
        direction.INCREASING
    } else if (a > b) {
        direction.DECREASING
    } else {
        direction.EQUAL
    }
}
