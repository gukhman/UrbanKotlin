import kotlin.random.Random

interface Matrix {
    fun getMatrix(m: Int, n: Int): Array<Array<Int>> {
        val matrix: Array<Array<Int>> = Array(m) { Array(n) { 0 } }
        println("Исходная матрица:")
        for (i in 0..<m) {
            for (j in 0..<n) {
                matrix[i][j] = Random.nextInt(0, 100)
                print("${matrix[i][j]}\t")
            }
            println()
        }
        return matrix
    }
}