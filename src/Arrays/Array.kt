import kotlin.math.pow

fun main() {
    task1()
    task2()
    task3()
    task4()
}

//1. Создать массив из 10 чисел с плавающей точкой. Найти произведение его элементов.
private fun task1() {
    val fArr = floatArrayOf(4F, 5F, 6F, 1F, 2F, 3F, 7F, 2.3F, 3.1F, 1.2F)
    var res = 1.0
    for (i in fArr) {
        res *= i
        //println(res)
    }
    println("1.\tПроизведение элементов массива ${fArr.contentToString()} = $res")

}

//2. Создать массив из 8 целых чисел. Найти среднее арифметическое его элементов.
private fun task2() {
    val iArr = intArrayOf(4, 5, 3, 1, 2, 5, 7, 456)
    println("2.\tСреднее арифметическое элементов массива ${iArr.contentToString()} = ${iArr.average()}")
}

//3. Дан массив размерностью size. Вывести в том же порядке все четные числа
//из данного набора и количество K таких чисел.
private fun task3() {
    val iArr = intArrayOf(4, 5, 3, 8, 46, 58, 96, 3333, 5, 7, 456)
    val iArrSize = iArr.size
    var k = 0
    print("3.\tНиже представлены только четные числа из массива ${iArr.contentToString()}:\n\t")
    for (i in 0..<iArrSize) {
        if (iArr[i] % 2 == 0) {
            print("${iArr[i]} ")
            k++
        }
    }
    print(": всего $k четных чисел\n")
}

//4. Дано целое число N(>0). Сформировать и вывести целочисленный массив размера N,
//содержащий степени двойки от первой до N-й: 2,4,8,16,….
private fun task4() {
    print("4.\tВведите число элементов массива: ")
    val nStr = readLine()
    val n = try {
        nStr!!.toInt()
    } catch (e: NumberFormatException) {
        null
    }
    var iArr = Array<Int>(n!!) { 0 }
    for (i in 1..n) {
        iArr[i-1] = 2.0.pow(i).toInt()
    }
    println("\tМассив степеней 2: ${iArr.contentToString()}")
}
