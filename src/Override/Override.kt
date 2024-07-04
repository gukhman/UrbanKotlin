fun main() {
    println("1."); ClassTask1().task1(); println("----------------------------------")
    println("2."); ClassTask2().task2(); println("----------------------------------")
    println("3."); ClassTask3().task3(); println("----------------------------------")
}
private class ClassTask1 {
    fun task1() {
        val nightingale = Blackbirds("Дрозд")
        nightingale.weight = 20
        println(nightingale.toString())
        nightingale.makeSound()
        println()

        val penguin = Penguins("Пингвин")
        penguin.weight = 15000
        println(penguin.toString())
        penguin.makeSound()
        println()

        val pelican = Pelicans()
        pelican.weight = 10000
        pelican.makeSound()
        println()

        val flamingo = Flamingoformes()
        flamingo.weight = 3000
        flamingo.makeSound()
    }
}

private class ClassTask2 : TextClear {
    fun task2() {
        val str =
            """1. Создать класс Bird(птица). Определить у него несколько свойств, например, тип(пеликанообразные, фламингообразные и тд). Создать в классе свойство, которое будет характеризовать по какому-то явному признаку, например, есть птицы, которые не могут подниматься в воздух или по –другому признаку. Определить функциональность класса птица. Создать несколько классов наследников, которые могут переопределять свойства и функции класса – родителя.
    2. Дан массив строк. Найти самоедлинноеслово в массиве и количество букв в этом слове.
    3. Дана строка «ПриВет, кАк деЛа». Необходимо найти символы, находящиеся в верхнем регистре, вывести их и посчитать их количество.
    """
        //val lines: List<String> = temp.lines()  //split многострочной строки на отдельные строки
        val temp = clearText(str)   //метод, очищающий текст от знаков препинания
        val words: List<String> = temp.split(" ")   //делим исходный текст на слова
        var len = 0     //длина слова
        var lword = ""   //слово
        for (word in words) if (word.length > len) {
            len = word.length
            lword = word
        }
        println("Самое длинное слово: $lword, его длина $len")
    }
}

private class ClassTask3 {
    fun task3() {
        val str = "ПриВет, кАк деЛа"
        var res = ""
        var num = 0
        for (char in str) {
            if (char.isUpperCase()) {
                res += " $char"
                num++
            }
        }
        println("Символы в верхнем регистре:$res, всего их $num")
    }
}