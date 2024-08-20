import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

suspend fun main() = coroutineScope {
    println("1."); Suspend1().task(); println("----------------------------------")
}

/*1. Написать класс Person с полями в конструкторе name и age, класс. Создать список persons,
в который включить несколько объектов этого класса. Написать класс Weather с полями
city, description, temp, создать список из нескольких объектов этого класса. Создать список случайных чисел
в диапазоне от 1 до 100 из 10 элементов. Представим, что эти три списка мы планируем загрузить с сервера.
Необходимо написать обобщенную suspend – функцию, принимающую на вход список параметра T
и в результат возвращающую скачанный этот же список. Она будет имитировать скачивание данных.
Внутри функции с задержкой в 1000L выводить скачанные данные. В главной функции нужно вызвать функции загрузки
трех имеющихся списков: personList, weatherList, randoms. Мы будем наблюдать,
как идет процесс загрузки (элементы в функции выводятся). Главный поток при их загрузке останавливается.
Когда загрузка заканчивается, в консоль выходит фраза «Данные загружены» и выводятся все три списка.
В завершении выходит фраза «Программа завершена».*/
private class Suspend1 {
    suspend fun task() = coroutineScope {
        val personList = arrayListOf(
            Person("Дмитрий", 22),
            Person("Александ", 25),
            Person("Полина", 27),
            Person("Мирон", 36),
            Person("Ирина", 24)
        )
        val cityList = arrayListOf(
            Weather("Дмитрий", "Калининград", 22F),
            Weather("Александ", "Зеленоградск", 20F),
            Weather("Полина", "Пионерский", 25F),
            Weather("Мирон", "Светлогорск", 26.7F),
            Weather("Ирина", "Балтийск", 23.2F)
        )
        val numbers = ArrayList<Int>()

        for (i in 1..10) {
            numbers.add(Random.nextInt(1, 101))
        }

        val tasks = launch {
            download(personList, "personList")
            download(cityList, "cityList")
            download(numbers, "numbers")
        }
        tasks.join()
        delay(1000L)
        
        println("Данные загружены:")
        println("$personList\n$cityList\n$numbers")
    }

    private suspend fun <T> download(list: T, name: String) {
        if (list is ArrayList<*>) {
            for (elem in list) {
                delay(1000L)
                println("Загрузка списка $name: $elem")
            }
        }
    }

    data class Person(val name: String, val age: Int)
    data class Weather(val city: String, val description: String, val temp: Float)
}