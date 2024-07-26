import kotlin.math.sqrt

fun main() {
    println("1."); Extensions1().task(); println("----------------------------------")
    println("2."); Extensions2().task(); println("----------------------------------")
    println("3."); Extensions3().task(); println("----------------------------------")
    println("4."); Extensions4().task(); println("----------------------------------")

}

/*1. Написать функцию расширения возведения в квадрат целого числа.*/
private class Extensions1 {
    fun task() {
        val a = 5
        println("$a^2 = ${a.squaring()}")
    }

    fun Int.squaring(): Int = this * this
}

/*2. Написать функцию расширения конкатенации строк.*/
private class Extensions2 {
    fun task() {
        val a = "Hello "
        println(a.concat("world!"))
    }

    fun String.concat(str: String): String = this + str
}

/*3. Написать функцию расширения определения последнего индекса в строке.*/
private class Extensions3 {
    fun task() {
        val a = "Hello world!"
        println("Встроенное свойство lastIndex: ${a.lastIndex}")    //встроенное свойство
        println("Функция расширения lastIndex(): ${a.lastIndex()}")  //функция расширения
        println("Функция расширения lastChar(): ${a.lastChar()}")   //последний символ строки
    }

    fun String.lastIndex(): Int = this.length - 1
    fun String.lastChar(): Char = this[this.length - 1]
}

/*4. Написать функцию получения квадратного корня из целого числа.*/
private class Extensions4 {
    fun task() {
        val a = 8
        println(sqrt(a.toDouble())) //kotlin.math
        println("%.5f".format(a.squareRoot()))     //функция расширения
    }

    fun Int.squareRoot(): Double {      //округление результата до 5 знака после запятой
        if (this < 0) {
            throw IllegalArgumentException("Квадратный корень не может быть извлечен из отрицательного числа")
        }
        if (this == 0 || this == 1) {
            return this.toDouble()
        }

        val precision = 0.00001
        var start = 0.0
        var end = this.toDouble()
        var mid = 0.0

        while ((end - start) > precision) {
            mid = (start + end) / 2
            val midSquared = mid * mid

            if (midSquared == this.toDouble()) {
                return mid
            } else if (midSquared < this.toDouble()) {
                start = mid
            } else {
                end = mid
            }
        }
        return (mid / precision).toInt() * precision
    }
}