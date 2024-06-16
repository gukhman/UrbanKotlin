/*Примечания:
- Используйте оператор If для всех пунктов задания*/

fun main() {
    task1()
    task2()
    task3()
    task4()
    task5()
    task6()
}

/*1. Дано целое число. Если оно является положительным, то прибавить к нему 1;
    в противном случае не изменять его. Вывести полученное число.*/
private fun task1() {
    var a = 10;
    if (a >= 0) {
        a++;
    }
    println("1. $a");
}

/*2. Даны целые числа: 4, 45, -2, 8. Найти количество положительных чисел в исходном наборе.*/
private fun task2() {
    val numbers = arrayOf(4, 45, -2, 8) //immutable
    var res = 0                         //mutable
    for (elem in numbers) {
        if (elem >= 0) {
            res++;
        }
    }
    println("2. В наборе ${numbers.contentToString()} $res положительных числа")
}

/*3. Даны два числа. Вывести большее из них.*/
private fun task3() {
    val a = -6.5
    val b = -9
    if (a > b) println("3. $a")
    else if (a < b) println("3. $b")
    else println("3. Заданием не определено что делать в таком случае")
}

/*4. Дано целое число в диапазоне 1–7. Вывести строку — название дня недели,
    соответствующее данному числу (1 — «понедельник», 2 — «вторник» и т. д.).*/
private fun task4() {
    var res = ""
    val day = (1..7).random()
    if (day == 1) res = "понедельник" else if (day == 2) res = "вторник" else if (day == 3) res = "среда"
    else if (day == 4) res = "четверг" else if (day == 5) res = "пятница" else if (day == 6) res = "суббота"
    else if (day == 7) res = "воскресенье"
    println("4. Сегодня $res")
}

/*5. Дано целое число K. Вывести строку-описание оценки, соответствующей числу
    (1 — «плохо», 2 — «неудовлетворительно», 3 — «удовлетворительно», 4 — «хорошо», 5 — «отлично»).
    Если не лежит в диапазоне 1–5, то вывести строку «ошибка».*/

private fun task5() {
    print("5. Введите оценку: ")
    val grade = readLine()
    var res = ""
    if (grade == "1") res = "плохо"
    else if (grade == "2") res = "неудовлетворительно"
    else if (grade == "3") res = "удовлетворительно"
    else if (grade == "4") res = "хорошо"
    else if (grade == "5") res = "отлично"
    else res = "ошибка"
    if (grade != null) {
        if (grade == "1" || grade == "2" || grade == "3" || grade == "4" || grade == "5")
            println("Ваша оценка $res")
        else println("ошибка")
    }
}

/*6. Арифметические действия над числами пронумерованы следующим образом:
    1 — сложение, 2 — вычитание, 3 — умножение, 4 — деление.
    Дан номер действия (целое число в диапазоне 1–4) и числа типа double(не равно 0).
    Выполнить над числами указанное действие и вывести результат.*/

private fun task6() {
    print("6. Введите действие(1 — сложение, 2 — вычитание, 3 — умножение, 4 — деление): ")
    val action = readLine()
    val a = 5.0
    val b = 2.0
    var res: Double = 0.0
    var act = ""

    if (action != null) {
        if (action == "1" || action == "2" || action == "3" || action == "4") {
            if (action == "1") {
                res = (a + b)
                act = "сложение"
            } else if (action == "2") {
                res = (a - b)
                act = "вычитание"
            } else if (action == "3") {
                res = (a * b)
                act = "умножение"
            } else if (action == "4") {
                res = (a / b)
                act = "деление"
            }
            println("Результат операции $act $a и $b = $res")
        } else println("Некорректный ввод!")
    }
}
