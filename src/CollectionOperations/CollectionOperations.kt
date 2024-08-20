fun main() {
    println("1."); CollectionOperations1().task(); println("----------------------------------")
    println("2."); CollectionOperations2().task(); println("----------------------------------")
    println("3."); CollectionOperations3().task(); println("----------------------------------")
    println("4."); CollectionOperations4().task(); println("----------------------------------")
}

/*1. Дан список строк произвольного размера. Вывести в консоль список, внутри которого располагаются
данные элементы, но каждый элемент представлен в реверсивном виде. Входной список: {"one", "two", "three"}.
Выходные данные: [eno, owt, eerht].*/
private class CollectionOperations1 {
    fun task() {
        val list = listOf("one", "two", "three")
        val editList = list.map { it.reversed() }
        println("Исходный массив: $list")
        println("Измененный массив: $editList")
    }
}

/*2. Создать список целых чисел. В новый список сохранить квадрат элементов
старого списка с условием, что исходный элемент меньше или равен 3.
Входной список: {1, 2, 3, 4, 5}. Выходные данные: [1, 4, 9]*/
private class CollectionOperations2 {
    fun task() {
        val list = listOf(1, 2, 3, 4, 5)
        val editList = list.filter { it <= 3 }.map { it * it }
        println("Исходный массив: $list")
        println("Измененный массив: $editList")
    }
}

/*3. Написать два списка. Один содержит значения цвета на английском языке, второй – значение цвета на русском.
Объединить списки и вывести информацию, содержащую значение и его перевод.
Входные данные: {"red", "blue", "white"}, {"красный", "синий", "белый"}.
Выходные данные: [Значение: red, перевод: красный, Значение: blue, перевод: синий, Значение: white, перевод: белый]*/
private class CollectionOperations3 {
    fun task() {
        val colorsEn = listOf("red", "blue", "white")
        val colorsRu = listOf("красный", "синий", "белый")
        println("Исходный массив: $colorsEn")
        println(colorsEn.zip(colorsRu) { en, ru -> "Значение: $en, перевод: $ru" })
    }
}

/*4. Дан массив строк, содержащий название месяцев. Посчитать общее количество символов,
содержащееся во всех строковых элементах.
Выходные данные: {"Jan", "Feb", "Mar", "Apr", "May}. Выходные данные: 15.*/
private class CollectionOperations4 {
    fun task() {
        val list = listOf("Jan", "Feb", "Mar", "Apr", "May")
        println("Исходный массив: $list")
        println(list.fold(0) { sum, elem -> sum + elem.length })
    }
}