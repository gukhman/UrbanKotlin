import kotlin.random.Random

fun main() {
    println("1."); Sort1().task(); println("----------------------------------")
    println("2."); Sort2().task(); println("----------------------------------")
    println("3."); Sort3().task(); println("----------------------------------")
}

/*1. Создать класс Employee, в конструкторе передать свойства имени, возраста и зарплаты. Создать список
сотрудников, состоящий из 5 человек. Написать функции сортировки по именам, возрасту и зарплате.*/
private class Sort1 {
    fun task() {
        val employees = listOf(
            Employee("Дмитрий", 34, 120_000),
            Employee("Валера", 33, 121_000),
            Employee("Мария", 32, 122_000),
            Employee("Михаил", 31, 123_000),
            Employee("Полина", 30, 124_000)
        )
        val empSortByName = employees.sortedBy { it.name }
        val empSortByAge = employees.sortedBy { it.age }
        val empSortBySalary = employees.sortedBy { it.salary }

        println("Сортировка по имени:\n$empSortByName")
        println("Сортировка по возрасту:\n$empSortByAge")
        println("Сортировка по ЗП:\n$empSortBySalary")
    }

    class Employee(val name: String, val age: Int, val salary: Int) {
        override fun toString(): String = "$name, $age, $salary\n"
    }
}

/*2. Дана матрица целых чисел размерностью 3х4. Отсортировать ее строки по возрастанию.*/
private class Sort2 {
    fun task() {
        val matrix = getMatrix(3, 4)
        val sortedMatrix: Array<Array<Int>> = Array(3) { Array(4) { 0 } }
        for (i in matrix.indices) {
            sortedMatrix[i] = matrix[i].sortedBy { it }.toTypedArray()
        }

        printMatrix(matrix, "Исходная матрица")
        println()
        printMatrix(sortedMatrix, "Отсортированная матрица")
    }
}

/*3. Дана матрица целых чисел размерностью 3х4. Проверить, являются ли внутренние массивы матрицы пилообразными, т.е. рядом с
элементом массива находятся соседи большие или меньшие его. Необходимо вывести количество пилообразных массивов и сами массивы.*/
private class Sort3 {
    fun task() {
        //внутренние массивы могут быть строками и столбцами
        //2-х соседей по строке имеют элементы с индексами [x][1] .. [x][n-1]
        //2-х соседей по столбцу имеют элементы с индексами [1][x] .. [m-1][x]
        val matrix = getMatrix(3, 4)
        var countSawArr = 0
        var sawArr: String
        val listStrSawArr = arrayListOf<String>()
        val listColSawArr = arrayListOf<String>()
        //найдем пилообразные массивы строк
        for (i in matrix.indices) {
            for (j in 1..<matrix[i].lastIndex) {
                if ((matrix[i][j] > matrix[i][j - 1] && matrix[i][j] > matrix[i][j + 1]) ||
                    (matrix[i][j] < matrix[i][j - 1] && matrix[i][j] < matrix[i][j + 1])
                ) {
                    countSawArr++
                    sawArr =
                        matrix[i][j - 1].toString() + " " + matrix[i][j].toString() + " " + matrix[i][j + 1].toString()
                    listStrSawArr.add(sawArr)
                }
            }
        }

        //найдем пилообразные массивы столбцов
        for (i in 1..<matrix.lastIndex) {
            for (j in matrix[i].indices) {
                if ((matrix[i][j] > matrix[i - 1][j] && matrix[i][j] > matrix[i + 1][j]) ||
                    (matrix[i][j] < matrix[i - 1][j] && matrix[i][j] < matrix[i + 1][j])
                ) {
                    countSawArr++
                    sawArr =
                        matrix[i - 1][j].toString() + " " + matrix[i][j].toString() + " " + matrix[i + 1][j].toString()
                    listColSawArr.add(sawArr)
                }
            }
        }

        printMatrix(matrix, "Исходная матрица")
        println()
        println("Количество пилообразных массивов: $countSawArr")
        println()
        println("Пилообразные массивы строк:\n$listStrSawArr")
        println()
        println("Пилообразные массивы столбцов:\n$listColSawArr")
    }
}

private fun getMatrix(m: Int, n: Int): Array<Array<Int>> {
    val matrix: Array<Array<Int>> = Array(m) { Array(n) { 0 } }
    for (i in 0..<m) {
        for (j in 0..<n) {
            matrix[i][j] = Random.nextInt(0, 100)
        }
    }
    return matrix
}

private fun printMatrix(matrix: Array<Array<Int>>, name: String) {
    println("\t$name:")
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            print("\t${matrix[i][j]}")
        }
        println()
    }
}