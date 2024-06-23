import kotlin.math.abs

fun main() {
    var a = 2
    var n = 10
    println("1.\t$a в степени $n = ${task1(a, n)}")
    a = 5
    var b = 10
    println("2.\tПроизведение чисел от $a до $b = ${task2(a, b)}")
    a = 12456
    b = -65460
    println("3.\tНОД $a и $b: ${task3(a, b)}")
}

//1. Написать функцию возведения числа a в степень n.
private fun task1(a: Int, n: Int): Int {
    var res = 1
    for (i in 1..n) {
        res *= a
    }
    //res = a.toDouble().pow(n).toInt()
    return res
}

//2. Написать функцию, которая принимает два целых числа a и b (a<b).
// Она вычисляет произведение всех целых чисел от a до b включительно.
private fun task2(a: Int, b: Int): Int {
    var res = 1
    for (i in a..b) {
        res *= i
    }
    return res
}

//3. Написать функцию, которая принимает два целых числа a и b.
// Результатом работы функции должен быть вычисленный наибольший общий делитель a и b.
private fun task3(a: Int, b: Int): String {
    //Если одно из чисел 0, то модуль другого и есть НОД. Если оба 0 - НОД не определен
    if (a == 0 && b != 0) return "${abs(b)}"
    else if (b == 0 && a != 0) return "${abs(a)}"
    else if (b == 0 && a == 0) return "не определен"
    else {
        var temp = 1
        var big = abs(a)
        var small = abs(b)
        if (a < b) {
            temp = big
            big = small
            small = temp
        }
        while (temp != 0) {
            temp = big % small
            big = small
            small = temp
        }
        return "$big"
    }
}