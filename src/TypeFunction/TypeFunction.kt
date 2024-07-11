fun main() {
    println("1."); TypeTask1().task(); println("----------------------------------")
    println("2."); TypeTask2().task(); println("----------------------------------")
    println("3."); TypeTask3().task(); println("----------------------------------")
}

/*1. Написать программу, которая будет вычислять факториал числа с применением рекурсии.*/
private class TypeTask1 : Notation {
    fun task() {
        val n = 6
        if (n >= 0) println("$n! = " + factorial(n)) else println("Некорректный ввод")
    }

    fun factorial(n: Int): Int = if (n <= 1) 1 else n * factorial(n - 1)
}

/*2. Написать функцию, которая находит N-ю степень числа 10 с применением рекурсии.*/
//в случае с 10 можно было просто в строке дописывать "0",
//но напишем универсальную функцию (для положительных целых числа и степени)
private class TypeTask2 : Notation {
    fun task() {
        val n = 10
        val deg = 4
        if (n > 0 && deg > 0) println("$n ^ $deg = " + pow(n, deg)) else println("Некорректный ввод")
    }

    fun pow(n: Int, deg: Int): Int = if (deg == 1) 1 else n * pow(n, deg - 1)
}

/*3. Дан массив val array = arrayOf(1, 2, 3, 4, 5, 6, 7). Написать функцию,
которая будет увеличивать элемент массива на единицу, находящийся через одну позицию.
Т.е. массив на выходе будет такой [2, 2, 4, 4, 6, 6, 8].*/
private class TypeTask3 : Notation {
    fun task() {
        val array = arrayOf(1, 2, 3, 4, 5, 6, 7)
        println("Исходный массив:\t${array.contentToString()}")
        increase(array)
        println("Измененный массив:\t${array.contentToString()}")
    }

    fun increase(arr: Array<Int>): Array<Int> {
        for (i in arr.indices) {
            if (i % 2 == 0) arr[i] += 1
        }
        return arr
    }
}