fun main() {
    println("1."); List1().task(); println("----------------------------------")
    println("2."); List2().task(); println("----------------------------------")
    println("3."); List3().task(); println("----------------------------------")
    println("4."); List4().task(); println("----------------------------------")
    println("5."); List5().task(); println("----------------------------------")
    println("6."); List6().task(); println("----------------------------------")
}

/*1. Дан список целых чисел. Вывести в консоль первый элемент списка двумя способами:
обратившись по индексу, через стандартную функцию first().*/
private class List1 {
    fun task() {
        val intList = listOf(42, 74, 6, 8, 19)
        println(intList[0])
        println(intList.first())
    }
}

/*2. Дан список целых чисел. Вывести в консоль среднее арифметическое элементов списка
двумя способами: в ручную – через цикл, с применением стандартной функции average().*/
private class List2 {
    fun task() {
        val intList = listOf(1, 7, 16, 30, 52)
        var average = 0.0
        intList.forEach { average += it }
        println(average / intList.size)
        println(intList.average())
    }
}

/*3. Дан список целых чисел. Вывести в консоль сумму элементов списка
двумя способами: в ручную – через цикл, с применением стандартной функции sum().*/
private class List3 {
    fun task() {
        val intList = listOf(4, 8, 15, 16, 23, 42)
        var sum = 0
        intList.forEach { sum += it }
        println(sum)
        println(intList.sum())
    }
}

/*4. Дан список целых чисел. Вывести в консоль количество элементов списка двумя
способами: в ручную – через цикл, с применением стандартной функции count().*/
private class List4 {
    fun task() {
        val intList = listOf(4, 8, 15, 16, 23, 42)
        var count = 0
        intList.forEach { count++ }
        println(count)
        println(intList.count())
    }
}

/*5. Дан список целых чисел. Вывести в консоль сумму двух последних элементов списка
двумя способами: в ручную – через цикл, с применением стандартной функции takeLast().*/
private class List5 {
    fun task() {
        val intList = listOf(4, 8, 15, 16, 23, 42)
        var sumOfLast2Elements = 0
        for (i in intList.indices) if (i >= intList.size - 2) sumOfLast2Elements += intList[i]
        println(intList.takeLast(2).sum())
        println(sumOfLast2Elements)
    }
}

/*6. Дан список целых чисел. Вывести в консоль сумму индексов элементов списка двумя
способами: в ручную – через цикл, с применением стандартной функции indices().*/
private class List6 {
    fun task() {
        val intList = listOf(4, 8, 15, 16, 23, 42)
        var sumOfIndexes = 0
        var index = -1
        for (elem in intList) {
            index++
            sumOfIndexes += index
        }
        println(sumOfIndexes)
        println(intList.indices.sum())
    }
}