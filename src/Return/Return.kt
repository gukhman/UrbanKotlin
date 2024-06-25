import kotlin.random.Random

fun main() {
    val arr = arrayOf(2, 5, 11, 58, 42, 7, 56, 4, 21, 2, 56, 546, 23, 12)
    println("1.\tЧисло локальных минимумов в переданном массиве составляет ${task1(arr)}\n")

    val arr2 = arrayOf(2, 5, -2, 8, 42, 7, -6, 4, -32, 2, 4, 3)
    println("2.\tОтрицательные элементы массива увеличены на 1:\n\t${task2(arr2).contentToString()}\n")

    print("3.")
    val matrix: Array<Array<Int>> = getMatrix(5, 7)
    val kStr = 1
    println("\tВыведем строку с индексом $kStr:\n\t${task3(kStr, matrix)}\n")
}

//1. Написать функцию, на вход которой поступает массив из произвольного количества элементов.
// Данная функция проверяет, если в массиве локальные минимумы и возвращает число локальных минимумов.
private fun task1(arr: Array<Int>): Int {
    var numOfMin = 0
    for (i in 1..arr.size - 2) {
        if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) numOfMin++
    }
    return numOfMin
}

//2. Напишите функцию, в которой проверяется созданный Вами массив целых чисел.
// Если в нем имеются отрицательные элементы, то необходимо увеличить этот элемент на единицу и вернуть массив.
private fun task2(arr: Array<Int>): Array<Int> {
    for (i in arr.indices) {    //цикл по индексам
        if (arr[i] < 0) {
            arr[i]++
        }
    }
    return arr
}

//3. Дана матрица размера M×N и целое число K (1≤K≤M). Вывести элементы K-й строки данной матрицы.
private fun task3(kStr: Int, matrix: Array<Array<Int>>): String = matrix[kStr].contentToString() //однострочная функция

fun getMatrix(m: Int, n: Int): Array<Array<Int>> {
    val matrix: Array<Array<Int>> = Array(m) { Array(n) { 0 } }
    println("\tИсходная матрица:")
    for (i in 0..<m) {
        for (j in 0..<n) {
            matrix[i][j] = Random.nextInt(0, 100)
            print("\t${matrix[i][j]}")
        }
        println()
    }
    return matrix
}