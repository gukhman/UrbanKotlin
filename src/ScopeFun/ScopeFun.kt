fun main() {
    println("1."); ScopeFun1().task(); println("----------------------------------")
    println("2."); ScopeFun2().task(); println("----------------------------------")
    println("3."); ScopeFun3().task(); println("----------------------------------")
}

/*1. Создайте scope – функцию let, которая будет вызываться у строки. В лямбда – выражении
этой функции выводится в консоль сам объект и длина этой строки.*/
private class ScopeFun1 {
    fun task() {
        val hi = "\"Добрый день\""
        hi.let { println("$it, длина этого сообщения ${it.length}") }
    }
}

/*2. Создать класс City, в конструкторе передается название города и population(население).
В главной функции создать его экземпляр, в конструктор передать название,
через функцию apply объекту назначить население в любом количестве.
Всю информацию об объекте, созданного City вывести в консоль.*/
private class ScopeFun2 {
    fun task() {
        val koenigCity = City("Калининград", null)
        koenigCity.apply {
            population = 489_735
            println("В городе $name проживает $population человека\n\t\t\t(по состоянию на 1 января 2023 года)")
        }
    }

    data class City(val name: String, var population: Int?)
}

/*3. Дан массив целых чисел. С помощью scope – функции with вывести в консоль
данный массив, количество элементов массива, сумму элементов массива.*/
private class ScopeFun3 {
    fun task() {
        val intList = listOf<Int>(42, 17, 38, 56, -7, 789)
        with(intList) {
            println("Массив: $this\n" +
                    "Количество элементов: ${this.size}\n" +
                    "Сумма элементов: ${this.sum()}")
        }
    }
}