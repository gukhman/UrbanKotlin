fun main() {
    println("1."); HighFun1().task(); println("----------------------------------")
    println("2."); HighFun2().task(); println("----------------------------------")
}

/*1. Написать функцию высшего порядка action, которая на вход принимает значения двух цветов типа String.
Они будут смешиваться в функции, которая на вход поступает в качестве третьего аргумента в action,
она же возвращает строку – получившейся цвет. Функция action возвращает результат в виде строки
смешанный цвет из двух заданных.*/
private class HighFun1 {
    fun task() {
        val color1 = Colors.YELLOW.toString()
        val color2 = Colors.RED.toString()

        println("При смешивании $color1 и $color2 получаем ${action(color1, color2, ::mix)}")
    }

    fun action(col1: String, col2: String, mix: (String, String) -> String): String {
        return mix(col1, col2)
    }

    fun mix(col1: String, col2: String): String {
        val res: String
        when (col1) {
            Colors.YELLOW.toString() -> res = when (col2) {
                Colors.BLUE.toString() -> Colors.GREEN.toString()
                Colors.RED.toString() -> Colors.ORANGE.toString()
                else -> "NOT DEFINED"
            }

            Colors.RED.toString() -> res = when (col2) {
                Colors.GREEN.toString() -> Colors.YELLOW.toString()
                Colors.BLUE.toString() -> Colors.MAGENTA.toString()
                Colors.YELLOW.toString() -> Colors.ORANGE.toString()
                else -> "NOT DEFINED"
            }

            Colors.BLUE.toString() -> res = when (col2) {
                Colors.YELLOW.toString() -> Colors.GREEN.toString()
                Colors.GREEN.toString() -> Colors.AQUAMARINE.toString()
                Colors.RED.toString() -> Colors.PURPLE.toString()
                else -> "NOT DEFINED"
            }

            Colors.GREEN.toString() -> res = when (col2) {
                Colors.RED.toString() -> Colors.YELLOW.toString()
                Colors.BLUE.toString() -> Colors.AQUAMARINE.toString()
                else -> "NOT DEFINED"
            }

            else -> res = "NOT DEFINED"
        }
        return res
    }
}

/*2. Написать функции изменения числа: одна – увеличение числа на единицу, вторая – умножение на два.
Написать функцию высшего порядка, которая на вход принимает массив целых чисел и вторым параметром функцию,
принимающую число и возвращающая число. Функция высшего порядка будет возвращать измененный массив,
который будет получаться за счет вызова внутри нее у этого массива функции map, внутри которой
будет вызываться функция изменения числа.*/
private class HighFun2 {
    fun task() {
        val arr = intArrayOf(1,2,3,4,5)
        println("Массив, элементы которого увеличены на 1: " + arrChange(arr,::addOne))
        println("Массив, элементы которого умножены на 2: " + arrChange(arr,::multTwo))
    }
    fun arrChange(arr: IntArray, change: (Int) -> Int): List<Int> {
        val arr2 = arr.map { change(it) }
        return arr2
    }
    fun addOne(num: Int): Int = num + 1
    fun multTwo(num: Int): Int = num * 2
}