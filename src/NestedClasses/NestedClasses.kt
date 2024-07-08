fun main() {
    println("1."); NestedTask1().task(); println("----------------------------------")
    println("2."); NestedTask2().task(); println("----------------------------------")
    println("3."); NestedTask3().task(); println("----------------------------------")
}

/*1.    Создать класс Human(человек). В нем создать несколько внутренних классов, например, head(голова), legs(ноги),
в каждом из классов напишите функции этой части тела. В главной функции опишите модель человека, вызвав всю функциональность написанных классов.*/
private class NestedTask1 {
    fun task() {
        val human = Human("Сергей", "Kotlin программист")
        print("В течении дня ${human.profession} ${human.name} использует ");human.head().think()
        println("А иногда нужен ${human.head().thinkMore()}")
        human.legs().move()
    }
}

/*2.    Дан строковый массив "Иванов", "Петров", "Сидоров", "Процветов", "Протасов".
Написать программу поиска и вывода на экран элементов массива по вводимым символам.
*/
private class NestedTask2 {
    fun task() {
        val list = arrayListOf("Иванов", "Петров", "Сидоров", "Процветов", "Протасов")
        println("Исходный массив: $list")
        var strToSearch: String
        while (true) {
            print("Введите строку для поиска (exit для выхода): ")
            strToSearch = readlnOrNull().toString()
            if (strToSearch == "exit" || strToSearch == "учше") break   //чтобы не путать раскладки=)
            if (strToSearch != "") {
                val res = list.filter { item -> item.contains(strToSearch) }//ищет по любому вхождению символов
                if (res.isNotEmpty()) println(res) else println("Ничего не найдено")
            } else {
                println("Пустой ввод недопустим")
                continue
            }
        }
    }
}

/*3.    Создать массив целых чисел, в котором есть два нулевых элемента, не идущих подряд.
Посчитать количество элементов, которые находятся между нолями.*/
private class NestedTask3 {
    fun task() {
        val intArray = IntArray(9) { i -> i + 1 }
        var firstZeroIndex = 0
        var secondZeroIndex = 0
        var firstZero = true
        intArray[1] = 0
        intArray[4] = 0
        intArray[6] = 0
//        val res = intArray.filterIndexed { index, item -> if (item > 0) index else null }
        for (i in intArray.indices) {
            if (intArray[i] == 0) {
                if (firstZero) {
                    firstZeroIndex = i  //индекс первого нулевого элемента
                    firstZero = false   //флаг первого нулевого элемента
                } else {
                    secondZeroIndex = i //после нахождения второго нулевого элемента выходим из цикла
                    break
                }
            }
        }
        println("Исходный массив: ${intArray.contentToString()}\n" +
                "Количество элементов между нулевыми: ${secondZeroIndex-firstZeroIndex-1}")
    }
}