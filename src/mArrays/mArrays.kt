import kotlin.random.Random

fun main() {
    task1()
    task2()
    task3()
    task4()
}

//1. Найти минимальный элемент в целочисленном массиве размера 3 х 3.
private fun task1() {
    val matrix: Array<Array<Int>> = Array(3) { Array(3) { 0 } }
    var firstRow = true
    var min = 0
    print("1.")
    for (i in 2 downTo 0) {
        for (j in 2 downTo 0) {
            matrix[i][j] = (i + 2) * (j + 3)
        }
        println("\t${matrix[i].contentToString()}")
        if (matrix[i].minOrNull() != null) {
            if (firstRow) {
                min = matrix[i].minOrNull()!!
                firstRow = false
            } else {
                if (matrix[i].minOrNull()!! < min) {
                    min = matrix[i].minOrNull()!!
                }
            }
        }
    }
    println("\tМинимальный элемент матрицы: $min")
}

//2. Создать матрицу размером 3 х 5. Найти элемент в этом массиве, который является средним(медиана).
//Найдем медиану каждой из строк матрицы
private fun task2() {
    val numOfStr = 3
    val numOfCol = 5
    val matrix: Array<Array<Int>> = Array(numOfStr) { Array(numOfCol) { 0 } }
    println("2.\tИсходная матрица:")
    for (i in 0..numOfStr - 1) {
        for (j in 0..numOfCol - 1) {
            matrix[i][j] = Random.nextInt(0, 100)
            print("\t${matrix[i][j]}")
        }
        println()
    }
    //закомментирован кусок, решающий задачу через перевод матрицы в 1-мерный массив и только для нечетного кол-ва элементов
    /*val matrix1D: Array<Int> = Array(numOfStr * numOfCol) { 0 }
    for (i in 0..numOfStr - 1) {
        for (j in 0..numOfCol - 1) {
            matrix1D[i * (numOfCol) + j] = matrix[i][j]
        }
    }
    matrix1D.sort()
    println("\tОдномерный сортированный массив:\n\t${matrix1D.contentToString()}")
    val medNum = (numOfStr * numOfCol - 1) / 2
    println("\tМедиана исходной матрицы ${matrix1D[medNum]}")*/

    //посчитаем медиану для каждой строки матрицы с учетом того что строк может быть четное количество
    val medMatrix: Array<Double> = Array(numOfStr) { 0.0 }
    val med: Double
    println("\tМассив медиан строк матрицы:")
    for (i in 0..numOfStr - 1) {
        matrix[i].sort()
        //println("\t${matrix[i].contentToString()}")
        if (numOfCol % 2 == 0) {
            medMatrix[i] = (matrix[i][numOfCol / 2 - 1] + matrix[i][numOfCol / 2]) / 2.0
        } else {
            medMatrix[i] = matrix[i][(numOfCol - 1) / 2].toDouble()
        }
        print("\t${medMatrix[i]}")
    }
    println()
    //Найдем медиану медиан
    medMatrix.sort()
    if (medMatrix.size % 2 == 0) {
        med = (medMatrix[medMatrix.size / 2 - 1] + medMatrix[medMatrix.size / 2]) / 2
    } else {
        med = medMatrix[(medMatrix.size - 1) / 2]
    }
    println("\tМедиана медиан исходной матрицы: $med")
}

//3. Дана матрица размером 5 х 5. Заполнить ее единицами в таком порядке:
/*0 0 0 0 0

0 0 0 0 0

0 0 1 0 0

0 1 1 1 0

1 1 1 1 1
*/
private fun task3() {
    val numOfStr = 5
    val matrix: Array<Array<Int>> = Array(numOfStr) { Array(numOfStr) { 0 } }
    var numOfOne = numOfStr     //количество "1" в строке матрицы (идут подряд посередине таблицы)
    var startPosOfOne = 0       //стартовая позиция, с которой идут единицы
    println("3.\tМатрица:")
    for (i in numOfStr - 1 downTo 0) {    //в последней строке матрицы все единицы
        numOfOne = 2 * (i + 1) - numOfStr       //в каждой новой строке количество "1" уменьшается на 2
        startPosOfOne = (numOfStr - numOfOne) / 2   //рассчитываем стартовую позицию, с которой в строке матрицы идут "1"
        for (j in 0..numOfOne - 1) {
            matrix[i][startPosOfOne + j] = 1
        }
    }
    for (i in 0..numOfStr - 1) {
        for (j in 0..numOfStr - 1) {
            print("\t${matrix[i][j]}")
        }
        println()
    }
}

//4. Дан набор целых чисел. Найти второе максимальное число.*/
private fun task4() {
    val nMax = 2
    val arrSize = 8
    val arr: Array<Int> = Array(arrSize) { 0 }
    println("4.\tИсходный массив:")
    for (i in 0..arrSize - 1) {
        arr[i] = Random.nextInt(0, 100)
        print("\t${arr[i]}")
    }
    arr.sortDescending()
    println("\n\t$nMax-е максимальное число в массиве: ${arr[nMax - 1]}")
}
