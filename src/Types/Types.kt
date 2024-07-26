fun main() {
    println("1."); Types1().task(); println("----------------------------------")
    println("2."); Types2().task(); println("----------------------------------")
    println("3."); Types3().task(); println("----------------------------------")
}

/*1. Дана строка, содержащая в себе значение 12.3. Преобразовать ее в целое число, число с плавающей точкой,
число в двоичной системе представления и вывести в консоль. Для части преобразований, например,
в двоичное представление, необходимо сделать несколько преобразований, чтобы целое число перевести в двоичное.*/
private class Types1 : Notation {
    fun task() {
        val str = "12.3"
        val intStr = str.toDouble().toInt()  //отбрасываем дробную часть
        println("Целое число: $intStr")
        println("Число с плавающей точкой: ${str.toDouble()}")
        println("Число в двоичной системе(без дробной части): ${decToBin(intStr)}")
    }
}

/*2. Написать функцию, которая проверяет чем, является вводимый аргумент
строкой, числом, числом с плавающей точкой, символом.
Ввод должен быть таким: «Это строка».*/
private class Types2 {
    fun task() {
        val one = "Привет"
        val two = 12
        val three = 12.3
        val four = 'Ы'
        println("$one - ${checkType(one)}")
        println("$two - ${checkType(two)}")
        println("$three - ${checkType(three)}")
        println("$four - ${checkType(four)}")
    }

    fun <T> checkType(input: T): String {
        val res: String = when (input) {
            is String -> "Это строка"
            is Int -> "Это число"
            is Double -> "Это число с плавающей точкой"
            is IntArray -> "Это массив целых чисел"
            is Char -> "Это символ"
            else -> "Это другой тип"
        }
        return res
    }
}

/*3. Написать функцию, которая на вход принимает типизированный параметр. Если это будет целое число,
то в консоль вывести сумму вводимого числа и единицы, если строка - сумму длины строки и единицы,
если массив целых чисел - сумму элементов массива.*/
private class Types3 {
    fun task() {
        val one = 42
        val two = "Hello"
        val three = intArrayOf(1, 2, 3, 4, 5)
        println("$one: ${doSomething(one)}")
        println("$two: ${doSomething(two)}")
        println("${three.contentToString()}: ${doSomething(three)}")
    }

    fun <T> doSomething(input: T): Int {
        var res = 0
        when (input) {
            is Int -> res = input + 1
            is String -> res = input.length + 1
            is IntArray -> res = input.sumOf { elem -> elem }
        }
        return res
    }
}
