fun main() {
    println("1."); EnumTask1().task(); println("----------------------------------")
    println("2."); EnumTask2().task(); println("----------------------------------")
}

/*1. Написать программу, которая будет включать несколько классов и enum. Ход работы следующий.
При запуске среда просит ввести месяц года. После ввода месяца и нажатия на enter, на консоль
выводится время года, которому соответствует этот месяц. После этого программа вновь
спросит желаете продолжить или закончить программу: 1. Продолжить; 2. Закончить программу.
Если нажимаем продолжить, то программа вновь просит ввести месяц и цикл повторяется.*/
private class EnumTask1 {
    fun task() {
        var firstStep = true    //флаг первого шага
        while (true) {
            if (!firstStep) {
                print(
                    "Введите\n" +
                            "1 - Продолжить\n" +
                            "2 - Для выхода из программы\n" +
                            ": "
                )
                val whatToDo = readln()
                while (true) {              //бесконечный цикл для обработки выбора "1"
                    when (whatToDo) {
                        "1" -> {
                            println()
                            break
                        }

                        "2" -> {
                            println("Завершаем работу программы")
                            //exitProcess(0)
                            return
                        }
                    }
                }
            }
            firstStep = false
            month()
        }
    }

    private fun month() {
        print("Введите месяц: ")
        val month = readln()
        when (month.uppercase()) {
            "ДЕКАБРЬ", EnumMonth.DECEMBER.toString(), "ЯНВАРЬ", EnumMonth.JANUARY.toString(),
            "ФЕВРАЛЬ", EnumMonth.FEBRUARY.toString() -> println("Результат: $month - это зима\n")

            "МАРТ", EnumMonth.MARCH.toString(), "АПРЕЛЬ", EnumMonth.APRIL.toString(),
            "МАЙ", EnumMonth.MAY.toString() -> println("Результат: $month - это весна\n")

            "ИЮНЬ", EnumMonth.JUNE.toString(), "ИЮЛЬ", EnumMonth.JULY.toString(),
            "АВГУСТ", EnumMonth.AUGUST.toString() -> println("Результат: $month - это лето\n")

            "СЕНТЯБРЬ", EnumMonth.SEPTEMBER.toString(), "ОКТЯБРЬ", EnumMonth.OCTOBER.toString(),
            "НОЯБРЬ", EnumMonth.NOVEMBER.toString() -> println("Результат: $month - это осень\n")

            else -> {
                println("Это не месяц\n")
                return
            }
        }
    }
}

/*2. Дана строка «Шумоизоляция». Посчитать количество повторяющихся символов.*/
private class EnumTask2 {
    fun task() {
        val str = "Шумоизоляция".uppercase()    //Если хотим не учитывать регистр
        val strChars = ArrayList<Char>()
        val letters = ArrayList<Char>()
        for (letter in str) {
            strChars.add(letter)
            if (!letters.contains(letter)) letters.add(letter)
        }
        var res = 0
        var resLet = ""
        for (letter in letters) {
            strChars.remove(letter)
            if (letter in strChars) {
                resLet += "\"$letter\" "
                res += 1
                while (letter in strChars) strChars.remove(letter)
            }
        }
        println("Количество повторяющихся букв в строке \"$str\": $res\n" +
                "Это буквы $resLet")
    }
}
