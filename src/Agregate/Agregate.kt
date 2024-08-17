fun main() {
    println("1."); Agregate1().task(); println("----------------------------------")
    println("2."); Agregate2().task(); println("----------------------------------")
    println("3."); Agregate3().task(); println("----------------------------------")
    println("4."); Agregate4().task(); println("----------------------------------")
}

/*1. Дан список целых чисел. Необходимо найти сумму его элементов начиная с 3 заканчивая 9.*/
private class Agregate1 {
    fun task() {
        val num = listOf(1, 2, 1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 15, 16)
        val sumFrom3To9 = num.foldIndexed(0) { id, sum, elem -> if (id in 2..8) sum + elem else sum }
        println("Исходный массив: $num")
        println("Сумма элементов с 3 по 9: $sumFrom3To9")
    }
}

/*2. Дан список целых чисел. С помощью функции fold вывести элементы этой коллекции в строку.
Т.е. входной список: val numbers = listOf(1, 2, 3, 4). Выходные данные: 1234*/
private class Agregate2 {
    fun task() {
        val num = listOf(3, 7, 1, 2, 3, 8, 5, 6, 7)
        val strNum = num.fold("") { str, number -> "$str$number" }
        println("Исходный массив: $num")
        println("Массив в строку: $strNum")
    }
}

/*3. Создать data класс Player, который характеризует игрока с именем, количеством заработанных очков и выигранных денег. Создать список
таких игроков с произвольными данными в конструкторе. Посчитать и вывести в консоль общее количество очков и выигранных денег.*/
private class Agregate3 {
    fun task() {
        val players = listOf(
            Player("Алексей Викторович Швед", 182, 1_300_000),
            Player("Андрей Геннадьевич Кириленко", 320, 1_400_000),
            Player("Сергей Валерианович Базаревич", 570, 1_500_000),
            Player("Тимофей Павлович Мозгов", 99, 12_100_000),
            Player("Андрей Константинович Воронцевич", 400, 900_000)
        )
        val scoreSum = players.sumOf { it.score }
        val salarySum = players.sumOf { it.salary }

        println("Сумма очков: $scoreSum")
        println("Сумма заработанных денег: $salarySum")
    }

    data class Player(val name: String, val score: Int, val salary: Int)
}

/*4. Дан список фруктов. Необходимо сгруппировать элементы этого списка по первому символу с таким расчетом,
чтобы в группу входили только фрукты с четной длиной строки каждого элемента. Т.е. входной список такой:
val fruits = listOf("Яблоко", "Абрикос", "Банан", "Виноград", "Вишня", "Кокос", "яблоко").
Выходной результат: {я=[Яблоко, яблоко], а=[], б=[], в=[Виноград], к=[]}*/
private class Agregate4 {
    fun task() {
        val fruits = listOf("Яблоко", "Абрикос", "Банан", "Виноград", "Вишня", "Кокос", "яблоко")
        val groupFruits = fruits.filter { it.length % 2 == 0 }.groupBy { it[0].lowercase() }
        println("Фрукты: $fruits")
        println("Фрукты отфильтрованы и сгруппированы: $groupFruits")
    }
}