import kotlin.random.Random

fun main() {
    task1()
    task2()
    task3()
    task4()
}

/*1. Создать класс Registration с полями email и password. Для этого свойства email
написать геттер, который возвращает значение этого поля в верхнем регистре.
Для поля password написать сеттер, который контролирует, чтобы длина пароля была
не менее 6 символов, иначе выводит сообщение, что не соответствует его длина.*/
private fun task1() {
    print("1.\t")
    val reg = Registration()
    reg.setPassword()
    print("\tEmail:")
    reg.getEmail()
    println()
}

//2. Написать функцию поиска четных чисел двумерного массива размерностью 4 х 4.
private fun task2() {
    print("2.")
    val n = 4
    val matrix: Array<Array<Int>> = getMatrix(n)
    print("\tЧетные элементы исходной матрицы: ")
    for (i in 0..<n) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] % 2 == 0) print("${matrix[i][j]} ")
        }
    }
    println("\n")
}

fun getMatrix(n: Int): Array<Array<Int>> {
    val matrix: Array<Array<Int>> = Array(n) { Array(n) { 0 } }
    println("\tИсходная матрица:")
    for (i in 0..<n) {
        for (j in 0..<n) {
            matrix[i][j] = Random.nextInt(0, 100)
            print("\t${matrix[i][j]}")
        }
        println()
    }
    return matrix
}

//3. Написать функцию заполнения двумерного массива 4 х 4 числами от 1 до 16 включительно.
private fun task3() {
    print("3.")
    val n = 4
    val matrix: Array<Array<Int>> = Array(n) { Array(n) { 0 } }
    println("\tМатрица с элементами по порядку:")
    for (i in 0..<n) {
        for (j in 0..<n) {
            matrix[i][j] = i * n + j + 1    //1 строка заполнится 1..n+1
            print("\t${matrix[i][j]}")
        }
        println()
    }
}

/*4. Написать функцию вывода в консоль положительных элементов массива. Проверка на положительность
 числа выполняется локальной функцией внутри вышеуказанной.*/
private fun task4() {
    println()
    val arr: Array<Int> = arrayOf(-2, -1, 0, 1, 2)
    println("4.\tИсходный массив: ${arr.contentToString()}")
    fun getPositive(arr: Array<Int>): ArrayList<Int> {
        val list: ArrayList<Int> = ArrayList()
        for (i in arr.indices) {
            if (arr[i] > 0) list.add(arr[i])
        }
        return list
    }
    println("\tПоложительные элементы массива: ${getPositive(arr)}")
}
