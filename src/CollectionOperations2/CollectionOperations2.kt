fun main() {
    println("1."); CollectionOperations21().task(); println("----------------------------------")
    println("2."); CollectionOperations22().task(); println("----------------------------------")
    println("3."); CollectionOperations23().task(); println("----------------------------------")
    println("4."); CollectionOperations24().task(); println("----------------------------------")
    println("5."); CollectionOperations25().task(); println("----------------------------------")
}

/*1. Дан список целых чисел от 1 до 20 включительно. Посчитать количество четных чисел списка,
начиная с 5 элемента до конца списка. Целесообразно использовать функции drop(), count().*/
private class CollectionOperations21 {
    fun task() {
        val list = arrayListOf<Int>()
        for (i in 1..20) list.add(i)
        val count = list.drop(list.size - 5).count { num -> num % 2 == 0 }
        println("Исходный массив: $list")
        println(
            "Количество четных чисел списка,\n" +
                    "начиная с 5 элемента до конца списка: $count"
        )
    }
}

/*2. Дан список целых чисел от 1 до 20 включительно.
Посчитать сумму первых 7 чисел списка, Целесообразно использовать функции take(), sum().*/
private class CollectionOperations22 {
    fun task() {
        val list = arrayListOf<Int>()
        for (i in 1..20) list.add(i)
        val sumFirst7 = list.take(7).sum()
        println("Исходный массив: $list")
        println("Сумма первых 7 чисел списка: $sumFirst7")
    }
}

/*3. Дан список строк: {"one", "two", "three"}. Необходимо получить и вывести в консоль
список вида:  [o, n, e, t, w, o, t, h, r, e, e]. Целесообразно использовать функции map(), flatten().*/
private class CollectionOperations23 {
    fun task() {
        val list = listOf("one", "two", "three")
        val editList = list.map { it.toCharArray().toList() }.flatten()
        println("Исходный массив: $list")
        println("Измененный массив: $editList")
    }
}

/*4. Дан список строк. Найти строку максимальной длины. Целесообразно использовать агрегатные операции.*/
private class CollectionOperations24 {
    fun task() {
        val list = listOf("one", "two", "three", "four", "five")
        val editList = list.fold("") { maxLenElem, elem -> if (elem.length > maxLenElem.length) elem else maxLenElem }
        println("Исходный массив: $list")
        println("Измененный массив: $editList")
    }
}

/*5. Написать класс Product с полями название и количество в конструкторе. Создать список продуктов,
состоящий из нескольких объектов класса. Посчитать общее количество продуктов, имеющихся на складе (в списке).
Целесообразно использовать функции map(), fold().*/
private class CollectionOperations25 {
    fun task() {
        val list = listOf(
            Product("Манго", 20),
            Product("Мандарин", 15),
            Product("Киви", 23),
            Product("Фейхуа", 6),
            Product("Личи", 9)
        )
        val count = list.fold(0) { sum, elem -> sum + elem.count }
        println("Исходный массив: $list")
        println("Общее количество продуктов: $count")
    }

    data class Product(val name: String, val count: Int)
}