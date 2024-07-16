fun main() {
    println("1."); Lambda1().task(); println("----------------------------------")
    println("2."); Lambda2().task(); println("----------------------------------")
    println("3."); Lambda3().task(); println("----------------------------------")
    println("4."); Lambda4().task(); println("----------------------------------")
}

/*1. Напишите функцию, которая запускает лямбду print() столько раз сколько будет указано в параметре count.
Например, чтобы передаваемое сообщение в print() выводилось count раз.*/
private class Lambda1 {
    fun task() = print("Это сообщение выведем 5 раз", 5)
    val print = { message: String, count: Int -> for (i in 1..count) println(message) }
}

/*2. Напишите программу, реализующую лямбда-выражение для вычисления
среднего арифметического списка чисел.*/
private class Lambda2 {
    fun task() = println("Среднее арифметическое массива: " + average(intArrayOf(4, 7, 5, 3, 8)))
    val average: (IntArray) -> Double = { arr -> arr.sum() / arr.size.toDouble() }
}

/*3. Дан массив произвольного набора чисел. Отфильтруйте его, чтобы в нем остались только положительные числа.*/
private class Lambda3 {
    fun task() = println("Положительные элементы массива: " + positive(intArrayOf(4, -7, -5, 3, 8)))
    val positive = { arr: IntArray -> arr.filter { it > 0 } }
}

/*4. 4. Напишите программу, которая реализует лямбда-выражение для работы с массивом целых чисел таким образом,
что его четные элементы делятся на 2, нечетные – умножаются на 3.*/
//1-й элемент массива - это элемент с нулевым индексом
//Т.к. массив целых чисел, то при делении на 2 его элементы будут терять дробную часть
private class Lambda4 {
    fun task() = println("Измененный массив: " + arrChange(intArrayOf(3, 2, 4, 5, 3)))
    val arrChange = { arr: IntArray ->
        for (i in arr.indices) if (arr[i] % 2 == 0) arr[i] /= 2 else arr[i] *= 3
        arr.contentToString()
    }
}