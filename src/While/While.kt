fun main() {
    task1()
    task2()
    task3()
    task4()
    task5()
    task6()
}

/*1. Пользователь вводит с клавиатуры число. Требуется посчитать факториал числа.
Например, если введено 3, факториал числа 1*2*3 = 6.*/
private fun task1() {
    print("1.\tВведите число: ")
    //var res = 1         //0! = 1; 	2,147,483,647   максимум 12!
    var res: Long = 1      //0! = 1;     // 9,223,372,036,854,775,807 максимум 20!
    val num = readlnOrNull()
    var intNum: Int? = try {
        num?.toInt()
    } catch (e: NumberFormatException) {
        null    //если введено не число то вернется null
    }
    //println(intNum)
    if (intNum != null) {
        if (intNum in 0..<21) {
            while (intNum > 1) {
                res *= intNum
                intNum--
            }
            println("\t$num! = $res")
        } else if (intNum >= 21) println("\tРезультат не помещается в тип Long")
        else println("\tНельзя вычислить факториал из отрицательного числа")
    } else println("\tНичего не введено")
}

/*2. Дано вещественное число — цена 1 кг конфет.
Вывести стоимость 1, 2, …, 10 кг конфет.*/
private fun task2() {
    val price = 2.50
    var i = 1
    var res = "\t"
    print("2.")
    while (i <= 10) {
        res = "\t$i" + "кг конфет стоит " + i * price + " руб."
        println(res)
        i++
    }
}

/*3. Даны два целых числа A и B (A<B). Вывести в порядке возрастания все целые числа,
расположенные между A и B (включая сами числа A и B), а также количество Nэтих чисел.*/
private fun task3() {
    val A = 5
    val B = 14
    var i = A
    var res = ""
    if (A < B) {
        res = "3.\tA = 5; B = 14\n\t"
        while (i <= B) {
            res += "$i "
            i++
        }
        res += ": всего " + (B - A + 1) + " чисел"
        println(res)
    } else println("\tПо условию A < B")
}

/*4. Дано целое число N (>0). Используя операции деления нацело и
взятия остатка от деления, вывести все его цифры,
начиная с самой правой.*/
private fun task4() {
    var N = 110230210150
    var res = "4.\tN = $N\n\tЦифры числа N в обратном порядке: "
    while (N >= 1) {
        res += N % 10
        res += " "
        N /= 10
    }
    println(res)
}

/*5. Напишите программу, в которой выводятся на экран числа от 1 до 20 включительно
со следующими условиями: если числа нечетные – их не выводить на экран,
если делятся на 4 без остатка – умножаем на 2, если число равно 19 завершаем программу.*/
private fun task5() {
    var i = 1
    print("5.")
    while (i <= 20) {
        when (i) {
            19 -> break
        }
        when (i % 2) {
            0 -> when (i % 4) {
                0 -> println("\ti = $i; f(i) = " + i * 4)
                else -> println("\ti = $i; f(i) = " + i)
            }
        }
        i++
    }
}

/*6. За каждый месяц банк начисляет к сумме вклада 7% от суммы. Напишите программу, в которой
вычисляется конечная сумма вклада с учетом начисления процентов за каждый месяц.
Сумма вклада равна 350, количество месяцев – 9.*/
private fun task6() {
    var sum = 350.0
    val monthCount = 9
    val percentInMonth = 7
    var i = 1
    while (i <= monthCount) {
        sum += sum * percentInMonth / 100
        //println("%.2f".format(sum))
        i++
    }
    println("6.\tИтоговая сумма с процентами: " + "%.2f".format(sum))
}