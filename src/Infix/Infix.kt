fun main() {
    println("1."); Infix1().task(); println("----------------------------------")
    println("2."); Infix2().task(); println("----------------------------------")
    println("3."); Infix3().task(); println("----------------------------------")
}

/*1. Написать четыре инфиксных функции: сложения, вычитания, умножения и деления.
В функции main применить их для разных операндов, результат вывести в консоль.*/
private class Infix1 {
    fun task() {
        val a = 15.0
        val b = 5.0
        println("a + b = ${a sum b}")
        println("a - b = ${a sub b}")
        println("a * b = ${a mult b}")
        println("a / b = ${a div b}")
    }

    //ф-и расширения для Double в виде scope функций
    infix fun Double.sum(a: Double): Double = this + a
    infix fun Double.sub(a: Double): Double = this - a
    infix fun Double.mult(a: Double): Double = this * a
    infix fun Double.div(a: Double): Double = this / a
}

/*2. Написать класс Person. В конструктор он принимает свойство имени.
Внутри класса есть инфиксная функция say, которая будет передавать
сообщение объекта этого класса, переданное в параметр. Сообщение внутри
функции выводится с помощью println.*/
private class Infix2 {
    fun task() {
        val heisenberg = Person("Walter Hartwell White")
        heisenberg sayMyName '!'    //проблема: не знаю как вызвать без аргумента, infix ф-я его требует
    }

    class Person(val name: String) {
        infix fun sayMyName(a: Char) = println(name)
    }
}

/*3. Создать data класс Point(точка), характеризующее место объекта. Написать две
инфиксные функции, расширяющие этот класс. Они характеризуют расположение одной
точки относительно другой – isAbove() – описывает ситуацию, когда одна точка выше
другой, isRightOf – описывает ситуацию, когда одна точка правее другой. В функции
main создать два объекта Point и сравнить их расположение, применив вышеуказанные функции.*/
private class Infix3 {
    fun task() {
        val a = Point(3.0, 5.0)
        val b = Point(4.0, 4.0)
        println("Точка а выше точки b? Ответ: ${a isAbove b}")
        println("Точка а правее точки b? Ответ: ${a isRightOf b}")
    }
    data class Point(val x: Double, val y: Double) {
        infix fun isAbove(p: Point) = this.y > p.y      //выше
        infix fun isRightOf(p: Point) = this.x > p.x   //правее
    }
}