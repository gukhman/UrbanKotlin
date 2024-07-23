fun main() {
    println("1."); Nullable1().task(); println("----------------------------------")
    println("2."); Nullable2().task(); println("----------------------------------")
    println("3."); Nullable3().task(); println("----------------------------------")
}

/*1. Написать функцию, которая выводит в консоль Вашу любимую книгу.
Входной параметр – название книги. Если в аргументы передается
значение null, вывести фразу «У меня нет любимой книги».*/
private class Nullable1 {
    fun task() {
        var book: String? = "Приключения Тома Сойера"
        println(book ?: "У меня нет любимой книги")
        book = null
        println(book ?: "У меня нет любимой книги")
    }
}

/*2. Создайте функцию, которая возвращает сколько раз целое число может быть разделено на другое
целое число без остатка. Функция должна возвращать null, если результатом деления является
не целое число. Назовите функцию DivideIfWhole. Дополнительно написать решение, в случае, когда
нет ни одного деления без остатка – вывести ноль. Рефакторинг сделать с применением оператора ?:*/
private class Nullable2 {
    fun task() {
        doIt(31, 3)
        doIt(32, 2)
    }

    private fun doIt(num1: Int, num2: Int) {
        val count: Int? = divideIfWhole(num1, num2)     //получаем число делений либо null
        val countExt: Int = count ?: 0                  //в случае null заменяем на 0
        println("Число \"$num1\" делится нацело на \"$num2\" $countExt раз")
    }

    fun divideIfWhole(num1: Int, num2: Int): Int? {
        var temp = num1
        var count = 0
        while (temp % num2 == 0) {
            temp /= num2
            count++
        }
        return if (count == 0) null else count
    }
}

/*3. Дан массив строк array = arrayOf("Привет","как", null, "дела"). Создать новый массив,
который будет состоять из элементов массива array, которые не являются null. Вывести их в консоль.*/
private class Nullable3 {
    fun task() {
        val array: Array<String?> = arrayOf("Привет", "как", null, "дела")
        var elements = ""
        for (elem in array) if (elem != null) elements += "$elem,"
        elements = elements.replace(".$".toRegex(), "")
        val array2: List<String> = elements.split(",")
        println("Исходный массив: ${array.contentToString()}\nСписок не null элементов исходного массива: $array2")
    }
}