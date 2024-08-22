import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

suspend fun main() {
    println("1."); AsyncAwaitReffered1().task(); println("----------------------------------")
}

private class AsyncAwaitReffered1 {
    suspend fun task() = coroutineScope {
        //посчитаем время в наносекундах
        val time = measureTimeMillis {
            val intList: List<Int> = generateRandomList("Int")
            val stringList: List<String> = generateRandomList("String")
            println("Элементы строкового списка:")
            unpack(stringList)
            println("\nЭлементы числового списка:")
            unpack(intList)
            println("\nКоличество, объединенный список:\n\t${concatenate(stringList, intList)}")
        }
        println("\nОбщее время выполнения (миллисекунды):\n\t$time")
    }

    //объединение списков разных типов
    fun <T, V> concatenate(list1: List<T>, list2: List<V>): Pair<Int, MutableList<T>> {
        val concatList = mutableListOf<T>()
        concatList.addAll(list1)
        list2.forEach { it -> (it as? T)?.let { concatList.add(it) } }
        return Pair(concatList.size, concatList)
    }

    //вывод элементов List с задержкой
    suspend fun <T> unpack(list: List<T>): Int {
        list.forEach {
            delay(1000L)
            println("\t$it")
        }
        return list.size
    }

    //функция генерирует List<Int> или List<String> в зависимости от переданного параметра
    fun <T> generateRandomList(type: String): List<T> {
        return when (type.lowercase()) {
            "int" -> List(10) { Random.nextInt(0, 101) as T }
            "string" -> {
                val text =
                    """1.     Написать функции getRandomList() создания списков рандомных чисел и символов. Данные функции могут быть перегруженными. Написать функцию распаковки списков unpack(), которые получаем из функций, описанных выше. Она обобщенная, т.е. может принимать список разных типов. Функция выводит в консоль элементы, но все через секундную задержку и в процессе ведет подсчет количества элементов (для имитации длительной работы). Возвращает количество элементов списка.

Также есть функция, объединяющая списки в один concatenate(). Учитывайте, что списки могут быть разных типов. Она возвращает объект Pair<Int, MutableList<T>>, где Int – количество элементов объединенного списка, MutableList<T> - сам список.

В функции main:

1.      Получить списки целых чисел и символов с помощью функций getRandomList(), состоящие из 10 элементов.

2.     Оба списка необходимо асинхронно распаковать.

3.     Вывести в консоль общий размер полученного списка.

4.     Объединить их функцией concatenate() и вывести в консоль полученный список.


5.     Посчитать общее время затраченных операций."""
                val clearedText = clearText(text)
                val words = clearedText.split(" ")
                List(10) { words.random() as T }
            }

            else -> throw IllegalArgumentException("Unsupported type")
        }
    }

    //очистка текста от знаков препинания и лишних пробелов
    private fun clearText(text: String) = text.replace(Regex("[\\d\\p{Punct}]"), "").replace(Regex("\\s+"), " ").trim()
}