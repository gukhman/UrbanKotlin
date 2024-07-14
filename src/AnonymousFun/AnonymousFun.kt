fun main() {
    println("1."); AnonFun1().task(); println("----------------------------------")
    println("2."); AnonFun2().task(); println("----------------------------------")
    println("3."); AnonFun3().task(); println("----------------------------------")
}

/*1. Написать анонимную функцию – поздравление с наступающим новым годом.
Ее тип следующий (String, Int) -> String. Где первый параметр имя,
кого поздравляют, второй с каким годом поздравляют. Эти аргументы должны
вписываться в контекст поздравления, которое составлено в теле функции.*/
private class AnonFun1 {
    fun task() {
        val congratulation = fun(name: String, year: Int): String = "Привет $name, поздравляю тебя с Новым $year годом!"
        println(congratulation("Алёна", 2024))
    }
}

/*2. Создать массив целых чисел произвольного размера. Написать анонимную функцию isEven,
проверяющую число на четность, она возвращает логический тип. Написать функцию
checkArrayElement проверки массива и его элементов на четность,
она на вход принимает массив и вторым параметром анонимную функцию типа isEven.*/
private class AnonFun2 {
    fun task() {
        val arr = arrayListOf(1, 2, 3, 4, 5)
        println("Исходный массив: $arr")
        println("Проверка на четность элементов исходного массива:\n${checkArrayElement(arr, isEven)}")
    }

    val isEven = fun(num: Int): Boolean = num % 2 == 0
    fun checkArrayElement(arr: ArrayList<Int>, ch: (Int) -> Boolean): List<Boolean> = arr.map { isEven(it) }
}

/*3. Напишите анонимную функцию для объединения двух строк и возврата результата.*/
private class AnonFun3 {
    fun task() {
        val str1 = "Привет, изучаешь Kotlin?"
        val str2 = "\nПривет! Да, в нем очень много интересных конструкций!"
        println(concat(str1, str2))
    }

    val concat = fun(str1: String, str2: String): String = "$str1$str2"
}