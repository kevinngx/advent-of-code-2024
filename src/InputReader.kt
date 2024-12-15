import java.io.FileReader

/** This class is used to read test input and return the result in the form of a matrix */
class InputReader {
    companion object {
        fun readInput(fileName: String): Array<String> {
            val lines = FileReader(fileName).readLines().toTypedArray<String>()
            return lines
        }
    }
}