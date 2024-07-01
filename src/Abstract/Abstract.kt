fun main() {
    println("1."); task1(); println("----------------------------------")
    println("2."); task2(); println("----------------------------------")
    println("3."); task3(); println("----------------------------------")
}

/*1. Написать абстрактный класс Shop(магазин). Написать несколько свойствкласса,
две абстрактные функции и одну обычную, характеризующих работу магазина.
Создать два класса наследника магазин Magnit и Pyaterochka. Написать реализацию функций.*/
private fun task1() {
    val magnit = Magnit()
    magnit.openTime = 10
    magnit.closeTime = 20
    magnit.type = "Гипермаркет"
    magnit.storeTraffic = 5000
    magnit.website = "https://magnit.ru/"
    magnit.whatType()
    magnit.isOpen()
    magnit.whatToSale()

    println()

    val pyaterochka = Pyaterochka()
    pyaterochka.openTime = 2
    pyaterochka.closeTime = 22
    pyaterochka.type = "Минимаркет"
    pyaterochka.storeTraffic = 170
    pyaterochka.website = "https://5ka.ru/"
    pyaterochka.whatType()
    pyaterochka.isOpen()
    pyaterochka.whatToSale()
}

/*2. Написать абстрактный класс Person. В конструкторе передать несколько свойств,
например, имени, фамилии, возраста. Написать абстрактныефункции, характеризующие
деятельность объекта класса и одну или несколько обычных. Создать два класса наследника
Student и Employee. Написать реализацию функций.*/
private fun task2() {
    val student = Student()
    student.name = "Василий"
    student.surname = "Теркин"
    student.age = 19
    student.profession = "Студент"
    println(student.manInfo())
    student.drive()
    student.programming()

    println()

    val employee = Employee()
    employee.name = "Дмитрий"
    employee.surname = "Букин"
    employee.age = 23
    employee.profession = "Разработчик"
    println(employee.manInfo())
    employee.drive()
    employee.programming()
}

/*3. Единицы длины пронумерованы следующим образом: 1 — дециметр, 2 — километр, 3 — метр,
4 — миллиметр, 5 — сантиметр. Дан номер единицы длины (целое число в диапазоне 1–5) и длина
отрезка в метрах (дробное число). Найти длину отрезка в тех величинах, под номером которых они находятся.
*/
private fun task3() {
    val type = 1
    val len = 57.8  //метров
    var res = 0.0
    when (type) {
        1 -> {res = len * 10; println("Длина составляет $res дециметров")}
        2 -> {res = len / 1000; println("Длина составляет $res километров")}
        3 -> {res = len; println("Длина составляет $res метров")}
        4 -> {res = len * 1000; println("Длина составляет $res миллиметров")}
        5 -> {res = len * 100; println("Длина составляет $res сантиметров")}
    }
}












