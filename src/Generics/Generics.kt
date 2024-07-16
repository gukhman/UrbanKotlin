fun main() {
    println("1."); Generic1().task(); println("----------------------------------")
    println("2."); Generic2().task(); println("----------------------------------")
    println("3."); Generic3().task(); println("----------------------------------")

}

/*1. Написать функцию print(), которая на вход может принимать различные типы.
Вызвать эту функцию несколько раз, поместив аргументы разных типов.*/
private class Generic1 {
    fun task() {
        print("Kotlin Programming Language")
        print(2024)
        print(3>2)
    }

    fun <T> print(message: T) = println(message)
}

/*2. Создать класс параметризованный класс Person, у которого свойство номера телефона
в конструкторе может передаваться по – разному, как в виде числа, так и в виде строки.
Создать Два экземпляра Person, поле телефона заполнить у первого числами, у второго строкой.
Вывести полученную информацию о них. Person: name = имя, phone = телефон*/
private class Generic2 {
    fun task() {
        val person1 = Person("Александр", 90624557814)
        val person2 = Person("Полина","+798645566789")
        println("${person1.name}, его номер телефона ${person1.phone}")
        println("${person2.name}, ее номер телефона ${person2.phone}")
    }

    data class Person<T>(val name: String, val phone: T)
}

/*3. Написать функцию вывода в консоль переменных разных типов данных. Вторым параметром в функции будет тип Char
и будет представлять то, во что будет оборачиваться переменная параметризованного типа, поступающая на вход
в качестве первого параметра. Например, переменная Int должна оборачиваться в фигурные скобки.
Пример ввода данных и полученного результата должен быть таким:
val a: Int = 10 -> {10}
val b: String = "Hello" -> [Hello]
val c: List<Int> = listOf(10, 16, 3) -> "[10, 16, 3]"
val d = 'f' -> (f)*/
private class Generic3 {
    fun task() {
        val a: Int = 10
        print(a,'{')
        val b: String = "Hello"
        print(b,'[')
        val c: List<Int> = listOf(10, 16, 3)
        print(c,'"')
        val d = 'f'
        print(d,'(')
    }

    fun <T> print(message: T, symbol: Char) = when (symbol) {
        '"' -> println("$symbol$message$symbol")
        '(' -> println("$symbol$message${symbol+1}*/")
        else -> println("$symbol$message${symbol+2}")
    }
}