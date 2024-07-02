import kotlin.math.abs

fun main() {
    println("1."); task1(); println("----------------------------------")
    println("2."); task2(); println("----------------------------------")
    println("3."); task3(); println("----------------------------------")
}

private fun task1() {
    val fireService = FireService()
    fireService.getInfo()
    fireService.callToService()
    println()
    val police = Police()
    police.getInfo()
    police.callToService()
    println()
    val medical = Medical()
    medical.getInfo()
    medical.callToService()
    println()
    val gas = Gas()
    gas.getInfo()
    gas.callToService()
}

/*2. Даны целые положительные числа A и B. Найти их наибольший общий делитель (НОД),
используя алгоритм Евклида: НОД(A,B) = НОД(B, A mod B), если B≠0; НОД(A, 0) = A.*/
private fun task2() {
    val a = 12456
    val b = -65460
    println("НОД $a и $b: ${gcd(a, b)}")
}

private fun gcd(a: Int, b: Int): String {   //greatest common divisor
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

/*3. Дан набор целых чисел. Найти второе максимальное число.*/
private fun task3() {
    //найдем максимальный элемент и удалим его. Возьмем максимальный опять -
    // он будет являться вторым максимальным из исходного набора
    val list = arrayListOf(7,5,2,2213,23,4,24,472,21,1,56,58,47)
    println("Исходный набор: $list")
    list.remove(list.max())
    println("Второй максимальный элемент: ${list.max()}")
}