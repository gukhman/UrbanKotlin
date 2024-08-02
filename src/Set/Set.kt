fun main() {
    println("1."); Set1().task(); println("----------------------------------")
    println("2."); Set2().task(); println("----------------------------------")
    println("3."); Set3().task(); println("----------------------------------")
    println("4."); Set4().task(); println("----------------------------------")
}

/*1. Разбить созданный набор на две коллекции, чтобы в одной содержались четные элементы, в другой – нечетные.*/
private class Set1 {
    fun task() {
        val numbers = setOf(5, 4, 3, 2, 1, 6, 8, 9, 11)
        val evenNumbers: MutableSet<Int> = mutableSetOf()
        for (elem in numbers) if (elem % 2 == 0) evenNumbers.add(elem)
        val oddNumbers = numbers subtract evenNumbers
        println(numbers)
        println(evenNumbers)
        println(oddNumbers)
    }
}

/*2. Дан набор целых чисел. Необходимо создать новое множество в который будут помещены элементы
прежнего умноженные на два, но с условием, что попадают в набор только элемент кратные пяти после умножения.
*/
private class Set2 {
    fun task() {
        //при умножении на 2 кратны 5 будут только те элементы, которые были кратны 5 до умножения
        val numbers = setOf(5, 4, 10, 2, 15, 6, 20, 9, 11)
        val newNumbers: MutableSet<Int> = mutableSetOf()
        for (elem in numbers) if (elem * 2 % 5 == 0) newNumbers.add(elem)
        println(numbers)
        println(newNumbers)
    }
}

/*3. Создать функцию removeDuplicates (collection: Collection<T>?), которая будет возвращать
набор неповторяющихся элементов. Обратите внимание, что в параметры функции передан
элемент Collection параметризованного типа.*/
private class Set3 {
    fun task() {
        val numbers = listOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5)  //исходный набор
        val newNumbers = removeDuplicates(numbers)          //без дупликатов
        println(numbers)
        println(newNumbers)
    }

    fun <T> removeDuplicates(collection: Collection<T>?): Set<T> {
        val res: MutableSet<T> = mutableSetOf()
        if (collection != null) {
            for (elem in collection) if (elem != null) res.add(elem)
        }
        return res
    }
}

/*4. Дан массив целых чисел. Нужно переместить все нули в конец массива,
сохранив порядок остальных элементов. Т.е. исходный массив 0, 6, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0
Результат: 6, 2, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0 */
private class Set4 {
    fun task() {
        //найдем нулевые элементы, уберем из list и добавим в конец list
        val numbers = listOf(0, 6, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0)
        val zeroNumbers = numbers.filter { it == 0 }    //list 0 элементов
        val newNumbers = (numbers subtract zeroNumbers).toMutableList()
        newNumbers += zeroNumbers
        println(numbers)
        println(newNumbers)
    }
}