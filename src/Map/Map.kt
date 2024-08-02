fun main() {
    println("1."); Map1().task(); println("----------------------------------")
    println("2."); Map2().task(); println("----------------------------------")
    println("3."); Map3().task(); println("----------------------------------")
}

/*1. *** Напишите функцию, которая получает на вход массив элементов типа К (Generic)
и возвращает Map<K, Int>, где K — значение из массива, а Int — количество вхождений в массив.
Т.е. массив val array = arrayOf(2, 4, 7, 1, 2, 4). Выходные данные: {1=1, 2=2, 4=2, 7=1}.*/
private class Map1 {
    fun task() {
        val numbers = listOf(1, 4, 3, 2, 3, 3, 8, 9, 4)
        val searchMap = search(numbers)
        println(numbers)
        println(searchMap)
    }

    fun <K> search(list: List<K>): Map<K, Int> {
        //если ключ уже есть в коллекции, тогда добавим его значению 1, если нет - добавим в коллекцию со значением 1
        val res: MutableMap<K, Int> = mutableMapOf()
        for (elem in list) {
            if (res.containsKey(elem)) res[elem] = res.getValue(elem) + 1 else res[elem] = 1
        }
        return res
    }
}

/*2. Дан map val people = mutableMapOf(1 to "Иван", 2 to "Петр",3 to "Лида", 4 to "Петр", 5 to "Анна").
Написать функцию, удаляющую элементы по введенному с клавиатуры значению.
Т.е., если набрали «Петр» коллекция должна стать такого вида {1=Иван, 3=Лида, 5=Анна}*/
private class Map2 {
    fun task() {
        val people = mutableMapOf(1 to "Иван", 2 to "Петр", 3 to "Лида", 4 to "Петр", 5 to "Анна")
        println("Набор элементов: $people")
        print("Введите значение для удаления из набора:")
        val input = readlnOrNull()
        if (input != null) delFromMap(input, people)
        println("Набор элементов после удаления: $people")
    }

    fun <K, V> delFromMap(value: V, map: MutableMap<K, V>) {
        if (map.containsValue(value)) {
            val mapKey = map.filterValues { it == value }
            for (key in mapKey.keys) map.remove(key)
        }
    }
}

/*3. Создать data класс Person, в конструктор он принимает свойства имени, возраста и должности.
В главной функции создать personHashMap и заполнить его несколькими элементами, где ключом будет
целое число – порядковый номер, значением – объект Person. Вывести полученную коллекцию в консоль.*/
private class Map3 {
    fun task() {
        val personHashMap: MutableMap<Int, Person> = mutableMapOf()
        val person2 = Person("Полина", 27, "Senior")
        val person3 = Person("Борис", 25, "Middle")
        personHashMap[1] = Person("Dmitry", 34, "Junior")
        personHashMap[2] = person2
        personHashMap[3] = person3
        println(personHashMap)
    }

    data class Person(val name: String, val age: Int, val position: String) {
        override fun toString(): String {
            return "|$name: $age лет, $position|\n"
        }
    }
}


















