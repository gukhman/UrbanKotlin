/*Примечания:
- Для вывода значений на экран используйте функцию println().*/
import kotlin.math.*

fun main() {
    task1()
    task2()
    task3()
    task4()
}

/*1. Дан порядковый номер месяца года. Нужно написать программу, которая будет
выводить на экран время года и название месяца. Пример вывода: «Зима: Январь.»*/
private fun task1() {
    var res = "1. "
    var season = ""
    var monthStr = ""
    val month = (1..12).random()
    when (month) {
        12, 1, 2 -> {
            season = "Зима"
            when (month) {
                12 -> monthStr = "Декабрь"
            }
            when (month) {
                1 -> monthStr = "Январь"
            }
            when (month) {
                2 -> monthStr = "Февраль"
            }
        }
    }
    when (month) {
        in 3..5 -> {
            season = "Весна"
            when (month) {
                3 -> monthStr = "Март"
            }
            when (month) {
                4 -> monthStr = "Апрель"
            }
            when (month) {
                5 -> monthStr = "Май"
            }
        }
    }
    when (month) {
        in 6..8 -> {
            season = "Лето"
            when (month) {
                6 -> monthStr = "Июнь"
            }
            when (month) {
                7 -> monthStr = "Июль"
            }
            when (month) {
                8 -> monthStr = "Август"
            }
        }
    }
    when (month) {
        in 9..11 -> {
            season = "Осень"
            when (month) {
                9 -> monthStr = "Сентябрь"
            }
            when (month) {
                10 -> monthStr = "Октябрь"
            }
            when (month) {
                11 -> monthStr = "Декабрь"
            }
        }
    }
    res += "$month-й месяц. $season: $monthStr."
    println(res)
}

//2. Дана переменная с плавающей точкой. Написать программу, которая округляет эту переменную до целого числа.
private fun task2() {
    val res = "2. Результат округления числа "
    //var resNum = 0.0
    val maxIntLen = 2       //максимальная длина целой части числа
    val maxFractionLen = 5  //максимальная длина дробной части числа
    //генерируем число с учетом указанных выше параметров
    val number = (1..<(10.0).pow(maxIntLen).toInt()).random() +
            (1..<(10.0).pow(maxFractionLen).toInt()).random().toDouble() / (10.0).pow(maxFractionLen)

    //Напишем округление используя when. Если дробная часть < 0.5, то округляем в меньшую сторону и наоборот
    /*when {
        ((number - number.toInt()) * 2 < 1) -> resNum = number.toInt()
        else -> resNum = number.toInt() + 1
    }*/
    val resNum = round(number)     //округление используя round()
    println("$res $number равен $resNum")
}

/*3. Написать программу, которая определяет время суток. Допустим с 0 часов до 5 -"Раннее утро",
с 6 до 11 – утро, с 12 до 17 - день, с 17 – 20 – вечер, после 20 до 23 – поздний вечер.*/

//В задании некорректно заданы интервалы, в программе исправлено на:
//0 часов до 5 -"Раннее утро", с 6 до 11 – утро, с 12 до 17 - день, с 18 – 20 – вечер, после 21 до 23 – поздний вечер
private fun task3() {
    var dayTime = ""
    val hour = (0..23).random()
    when (hour) {
        in 0..5 -> {
            dayTime = "Раннее утро"
        }

        in 6..11 -> {
            dayTime = "утро"
        }

        in 12..17 -> {
            dayTime = "день"
        }

        in 18..20 -> {
            dayTime = "вечер"
        }

        in 21..23 -> {
            dayTime = "поздний вечер"
        }
    }
    println("3. $hour часов - это $dayTime")
}

//4. Даны две переменные a = 8, b = 5. Написать алгоритм, при котором a = 5, b = 8.
private fun task4() {
    var a = 8
    var b = 5
    println("4. До смены значений a = $a, b = $b")
    //меняем значения переменных местами
    val temp = a
    a = b
    b = temp
    println("   После смены значений a = $a, b = $b")
}


