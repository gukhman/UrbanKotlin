import kotlin.math.abs
import kotlin.random.Random

fun main() {
    task1()
    task2()
    task3()
    task4()
    task5()
}

/*1. Создать класс Box(коробка), у которого есть свойства width, height, depth.
Написать функцию вычисления объёма коробки в классе Box. В классе с функцией main
создать экземпляр класса Box, в конструктор класса передать свойства,
задать им значения, вызвать функцию вычисления объема и вывести его на экран.*/
private fun task1() {
    val box = Box(3.0, 5.0, 7.0)
    println("1.\tОбъем коробки ${box.getVolume()}")
}

/*2. Дан набор из N чисел. Найти минимальный и максимальный
из элементов данного набора и вывести их.*/
private fun task2() {
    val n = 10
    val list: ArrayList<Int> = ArrayList()
    for (i in 0..<n) {
        list.add(Random.nextInt(-10, 10))
    }
    println("2.\tИсходный набор чисел:\n\t${list}")
    val max = list.maxOrNull()
    val min = list.minOrNull()
    println("\tМинимальный элемент: $min, максимальный элемент: $max")
}

//3. Дан массив целых чисел 3, 67, 1, 55, 65, 89, 23. Вывести на экран элементы массива.
private fun task3() {
    val arr = arrayOf(3, 67, 1, 55, 65, 89, 23)
    print("3.\t")
//    for (elem in arr) print("$elem ")
//    println()
    println(arr.contentToString())
}

/*4. Дано целое число. Вывести его строку-описание вида «отрицательное четное число»,
«отрицательное нечетное число» «нулевое число», «положительное нечетное число»,
«положительное четное число». int a = 34 à «положительное четное число»*/
private fun task4() {
    val a = -123
    var res = "число"
    if (a == 0) {
        res = "нулевое число"
    } else {
        when (abs(a % 2)) {
            0 -> res = "четное $res"
            1 -> res = "нечетное $res"
        }
        when {
            a < 0 -> res = "отрицательное $res"
            a > 0 -> res = "положительное $res"
        }
    }
    println("4.\t$a $res")
}

/*5. Создайте класс Car. В классе есть конструктор с параметрами массы, скорости.
В классе с функцией main создайте экземпляр этого класса и задайте там параметры в конструктор.
Напишите функции движения и остановки автомобиля.*/
private fun task5() {
    val carLada = Car("ВАЗ 2109 Зубило", 1300, 110)
    print("5.\t")
    carLada.move()
    print("\t")
    carLada.stop()
    val carLamba = Car("Lamborghini Huracan", 1600, 35)
    print("\t")
    carLamba.move()
    print("\t")
    carLamba.stop()
    val carPorche = Car("Porche 911 Targa 4S", 1700, 0)
    print("\t")
    carPorche.move()
    print("\t")
    carPorche.stop()
}