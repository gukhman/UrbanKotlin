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
   /* val str = """1. Соз
    2. Дан масс
    hk"""
    val byteStr = str.toByteArray()
    for (char in str.indices){
        print(char.toString() + " " + str[char] + " " + str[char].toInt() + "\n")
    }*/

    val str = """1. Создать класс Bird(птица). Определить у него несколько свойств, например, тип(пеликанообразные, фламингообразные и тд). Создать в классе свойство, которое будет характеризовать по какому-то явному признаку, например, есть птицы, которые не могут подниматься в воздух или по –другому признаку. Определить функциональность класса птица. Создать несколько классов наследников, которые могут переопределять свойства и функции класса – родителя.
2. Дан массив строк. Найти самое длинное слово в массиве и количество букв в этом слове.
3. Дана строка «ПриВет, кАк деЛа». Необходимо найти символы, находящиеся в верхнем регистре, вывести их и посчитать их количество.
"""
    val del = 10.toString()
    val arr = arrayOf(str.split(del))  //разобьем многострочный текст на массив строк

    println(arr[0])
}