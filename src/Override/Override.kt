fun main() {
//    println("1."); task1(); println("----------------------------------")
    println("2."); task2(); println("----------------------------------")
//    println("3."); task3(); println("----------------------------------")
}

private fun task1() {
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

private fun task2() {
    /*    val str =
            """1. Создать класс Bird(птица). Определить у него несколько свойств, например, тип(пеликанообразные, фламингообразные и тд). Создать в классе свойство, которое будет характеризовать по какому-то явному признаку, например, есть птицы, которые не могут подниматься в воздух или по –другому признаку. Определить функциональность класса птица. Создать несколько классов наследников, которые могут переопределять свойства и функции класса – родителя.
    2. Дан массив строк. Найти самое длинное слово в массиве и количество букв в этом слове.
    3. Дана строка «ПриВет, кАк деЛа». Необходимо найти символы, находящиеся в верхнем регистре, вывести их и посчитать их количество.
    """*/
    val str =
        """а). Определить у него несколько свойств, например, тип(пеликанообразные, фламингообразные и тд). Создать в классе свойство, которое будет характеризовать по какому-то явному признаку, например, есть птицы, которые не могут подниматься в воздух или по –другому признаку. Определить функциональность класса птица. Создать несколько классов наследников, которые могут переопределять свойства и функции класса – родителя.
2. Дан массив строк. Найти самое длинное слово в массиве и количество букв в этом слове.
3. Дана строка «ПриВет, кАк деЛа». Необходимо найти символы, находящиеся в верхнем регистре, вывести их и посчитать их количество.
"""

    var temp = str.trim()
    var rem = 0
    while (rem == 0) {
        for (i in temp.indices) {
            when (temp[i]) {
                ",".toCharArray()[0] -> {
                    rem = 1;break
                }

                ".".toCharArray()[0] -> {
                    rem = 2;break
                }

                "(".toCharArray()[0] -> {
                    rem = 3;break
                }

                ")".toCharArray()[0] -> {
                    rem = 4;break
                }

                "–".toCharArray()[0] -> {
                    rem = 5;break
                }
            }
        }
        if (rem == 0) break
        when (rem) {
            1 -> temp = temp.replace(",", " ")
            2 -> temp = temp.replace(".", " ")
            3 -> temp = temp.replace("(", " ")
            4 -> temp = temp.replace(")", " ")
            5 -> temp = temp.replace("–", " ")
        }
        rem = 0
    }
    //val lines: List<String> = temp.lines()  //split многострочной строки на отдельные строки
    val words: List<String> = temp.split(" ")
    var len = 0
    var word = ""
    for (i in words.indices) if (words[i].length > len) {
        len = words[i].length
        word = words[i]
    }
    println("$word: $len")
}