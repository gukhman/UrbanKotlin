fun main() {
    println("1."); String1().task(); println("----------------------------------")
    println("2."); String2().task(); println("----------------------------------")
    println("3."); String3().task(); println("----------------------------------")
    println("4."); String4().task(); println("----------------------------------")
}

/*1. Дана строка «Занятие». Вывести на экран символы, составляющие данную строку.*/
private class String1 {
    fun task() {
        val str = "Занятие"
        chars(str)
    }

    val chars = { str: String ->
        str.forEach { elem -> print("$elem ") }
        println()
    }
}

/*2. Нужно осуществить проверку номера телефона. Он должен начинаться с +7
и содержать 10 цифр, не считая +7. Если телефон верно введен, выведите true, иначе false.*/
private class String2 {
    fun task() {
        val str = "+79114788562"
        val res = "Номер введен"
        if (phoneCheck(str)) println("$res корректно") else println("$res некорректно")
    }
}

val phoneCheck = { phone: String ->
    phone.substring(0, 2) == "+7"
            && phone.length == 12
            && phone.replace("+7", "").toBigIntegerOrNull() != null
}

/*3. Дана строка. Вывести символы, составляющие эту строку, но в обратном порядке.*/
private class String3 {
    fun task() {
        val str = "Это не палиндром"
        println(str.reversed()) //строка в обратном порядке
        for (i in str.length - 1 downTo 0) print("${str[i]} ")  //символы строки в обратном порядке
        println()
    }
}

/*4. Дана строка «kotlin2023course». Подсчитать количество содержащихся в ней цифр.*/
private class String4 {
    fun task() {
        val str = "kotlin2023course"
        var i = 0
        str.forEach { elem -> if (elem.digitToIntOrNull() != null) i++ }
        println("В исходной строке содержится $i цифры")
    }
}