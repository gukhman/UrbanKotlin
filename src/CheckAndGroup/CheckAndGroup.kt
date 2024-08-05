fun main() {
    println("1."); Check1().task(); println("----------------------------------")
    println("2."); Check2().task(); println("----------------------------------")
    println("3."); Check3().task(); println("----------------------------------")
}

/*1. Дан список слов в произвольном порядке по алфавиту. Необходимо сгруппировать элементы по первому символу.*/
private class Check1 {
    fun task() {
        val list = listOf("Привет", "Мир", "Дружба", "Жвачка", "Пока", "Мама", "Добро")
        val groups = list.groupBy { it.first() }
        println(groups)
    }
}

/*2. Дан список строк. Необходимо сгруппировать его по длине строки.*/
private class Check2 {
    fun task() {
        val list = listOf("Привет", "Мир", "Дружба", "Жвачка", "Пока", "Мама", "Добро")
        val groups = list.groupBy { it.length }
        println(groups)
    }
}

/*3. Дан список телефонов по году выпуска phoneToYear. Не забывайте он может выглядеть как map(ключ - значение),
но на самом деле внутри себя будет содержать объект Pair. Необходимо сгруппировать объекты по годам выпуска телефонов. */
private class Check3 {
    fun task() {
        val phoneToYear = mapOf(
            "Nokia 3310" to 2000,
            "Ericsson T68i" to 2001,
            "Siemens ME45" to 2001,
            "Samsung C100" to 2003,
            "Siemens SX1" to 2003,
            "Motorola RAZR V3" to 2004,
            "Siemens M65" to 2004,
            "Nokia N70" to 2005
            )
        val phoneGroup = phoneToYear.toList()
        println(phoneGroup.groupBy { it.second })
    }
}