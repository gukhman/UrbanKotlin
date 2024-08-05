fun main() {
    println("1."); Filter1().task(); println("----------------------------------")
    println("2."); Filter2().task(); println("----------------------------------")
    println("3."); Filter3().task(); println("----------------------------------")
    println("4."); Filter4().task(); println("----------------------------------")
}

/*1. Дан map, в которой элементы содержат ключ целое число, значения имена.
Отфильтруйте ее по значению ключа, допустим, менее значения равного 5.*/
private class Filter1 {
    fun task() {
        val data = mapOf(
            7 to "Дмитрий",
            5 to "Василий",
            2 to "Марианна",
            8 to "Антон",
            3 to "Александра"
        )
        println(data.filter { it.key < 5 })
    }
}

/*2. Дан map, в которой элементы содержат ключ целое число, значения имена.
Отфильтруйте по значениям, оканчивающимся на букву «а».*/
private class Filter2 {
    fun task() {
        val data = mapOf(
            7 to "Дмитрий",
            5 to "Василий",
            8 to "Антон",
            3 to "Александра"
        )
        println(data.filter { it.value.endsWith('а') })
    }
}

/*3. Дан map, в которой элементы содержат ключ целое число, значения имена.
Отфильтруйте по значениям, Начинающимся на букву «Г».*/
private class Filter3 {
    fun task() {
        val data = mapOf(
            7 to "Григорий",
            5 to "Василий",
            2 to "Марианна",
            8 to "Антон",
            3 to "Георгий"
        )
        println(data.filter { it.value.startsWith('Г') })
    }
}

/*4. Дан map prizeMap, описывающий ключом порядковый номер сотрудника, значение характеризует
процент премии сотруднику. Отфильтровать исходный map с таким расчетом, чтобы получить данные
сотрудников, чей порядковый номер оканчивается на «5» и процент премии больше 20.*/
private class Filter4 {
    fun task() {
        val prizeMap = mapOf(
            1 to 30,
            2 to 70,
            3 to 50,
            4 to 100,
            5 to 600,
            15 to 30,
            25 to 10,
            10 to 75
        )
        println(prizeMap.filter { (key, value) -> key.toString().endsWith('5') && value > 20 })
    }
}
