fun main() {
    println("1."); AnonTask1().task(); println("----------------------------------")
    println("2."); AnonTask2().task(); println("----------------------------------")
    println("3."); AnonTask3().task(); println("----------------------------------")
}

private class AnonTask1 : TextProcessing {
    fun task() {
        var str = """ПРАКТИЧЕСКОЕ ЗАДАНИЕ
2023/12/19 00:00|Домашнее задание по теме "Анонимные классы."
Домашнее задание по теме "Анонимные классы."
Ваша задача:
1. Дан массив строк. Найти самое длинное слово в массиве и количество букв в этом слове.
2. Посчитать сумму элементов побочной диагонали матрицы 4х4.
3. Написать абстрактный класс Printer со своими свойствами и функциями. В функции main создать несколько объектов Printer.
Решение
Здесь вы можете отправить свое решение на проверку. Можно написать текст. Преподаватель может оценить его и прокомментировать."""
        str = clearText(str)    //удалим спецсимволы
        val lines =
            str.lines()  //split многострочной строки на отдельные строки нужен, чтобы корректно обработать переносы строки
        val words = arrayListOf("")
        for (line in lines) {
            words += line.split(" ")
        }
        var len = 0     //длина слова
        var lword = ""   //слово
        for (word in words) {
            //println(word)
            if (word.length > len) {
                len = word.length
                lword = word
            }
        }
        println("Самое длинное слово: $lword, его длина $len")
    }
}

private class AnonTask2 : Matrix {
    fun task() {
        val n = 4
        var res = 0
        val matrix = getMatrix(n, n)
        //Побочной диагональю матрицы называется диагональ, проведённая из левого нижнего угла матрицы в правый верхний
        //41,32,23,14
        for (i in 1..n) {
            res += matrix[n - i][i - 1]
            //println(matrix[n - i][i-1])
        }
        println("Сумма элементов побочной диагонали: $res")
    }
}

private class AnonTask3 {
    fun task() {
        val printer = object : Printer("Струйный", "Xerox") {
            override fun toPrint() {
                println("Запускаем печать пробной страницы на $type принтере модели $model")
            }

            override fun info() {
                println("Принтер $model подключен к компьютеру по USB")
            }
        }
        val printerMFP = object : Printer("Лазерный", "HP") {
            override fun toPrint() {
                println("Запускаем печать пробной страницы на $type принтере модели $model")
            }

            override fun info() {
                println("Принтер $model подключен к локальной сети")
            }
        }
        printer.toPrint()
        printer.info()
        printerMFP.toPrint()
        printerMFP.info()
    }
}