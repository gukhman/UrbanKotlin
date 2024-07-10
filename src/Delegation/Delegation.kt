fun main() {
    println("1."); ByTask1().task(); println("----------------------------------")
    println("2."); ByTask2().task(); println("----------------------------------")
    println("3."); ByTask3().task(); println("----------------------------------")
}

/*1. Написать программу перевода числа из десятичной системы в двоичную систему счисления.*/
private class ByTask1 : Notation {
    fun task() {
        var decimal = 0
        var inputOK = false
        while (!inputOK) {
            print("Введите целое число: ")
            val inputStr = readln()
            if (decimalCheck(inputStr)) {
                decimal = inputStr.toInt()
                inputOK = true
            } else {
                println("Некорректный ввод")
                continue
            }
        }
        println("В двоичной системе счисления: ${decToBin(decimal)}")
    }
}

/*2. Написать программу перевода числа из двоичной системы в десятичную систему счисления.*/
private class ByTask2 : Notation {
    fun task() {
        var binary = ""
        var inputOK = false
        while (!inputOK) {
            print("Введите двоичное число: ")
            val inputStr = readln()
            if (binaryCheck(inputStr)) {
                binary = inputStr
                inputOK = true
            } else {
                println("Некорректный ввод")
                continue
            }
        }
        println("В десятичной системе счисления: ${binToDec(binary)}")
    }
}

/*3. Написать программу, которая проверяет, является ли слово палиндромом.*/
private class ByTask3 {
    fun task() {
        var stop = false        //флаг выхода
        var firstStep = true    //флаг первого шага
        var whatToDo = "1"      //выбор действия
        while (!stop) {
            if (!firstStep) {
                print(
                    "Введите\n" +
                            "1 - Продолжить\n" +
                            "2 - Для выхода из программы\n" +
                            ": "
                )
                whatToDo = readln()
                when (whatToDo) {
                    "1" -> {
                        println()
                    }

                    "2" -> {
                        println("Завершаем работу программы")
                        stop = true
                    }

                    else -> {
                        println("Некорректный ввод\n")
                        continue
                    }
                }
            }
            if (whatToDo == "1") {
                firstStep = false
                print("Введите строку для проверки является ли она палиндромом: ")
                val input = readln()
                val res = isPalindrome(input)
                if (res) println("\"$input\" - это палиндром") else println("\"$input\" не является палиндромом")
            }
        }
    }

    private fun isPalindrome(word: String): Boolean {
        var temp = word.uppercase()
        while (temp.contains(" ")) temp = temp.replace(" ","")
        var reverseWord = ""
        for (i in temp.lastIndex downTo 0) reverseWord += temp[i]
        return temp == reverseWord
    }
}