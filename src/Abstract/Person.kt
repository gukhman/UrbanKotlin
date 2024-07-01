abstract class Person {
    var name = ""
    var surname = ""
    var age = 0
    var profession = ""

    fun manInfo(): String {
        return ("Человеку по имени $name $surname сейчас $age. " +
                "\nЕго профессия - $profession")
    }

    abstract fun drive()
    abstract fun programming()
}

class Student : Person() {
    override fun drive() {
        println("Водит Lada Granta")
    }

    override fun programming() {
        println("Изучает JAVA и Kotlin")
    }

}

class Employee : Person() {
    override fun drive() {
        println("Водит Porsche 911 Targa 4S")
    }

    override fun programming() {
        println("Создает приложения на JAVA и Kotlin, " +
                "\nизучает психологию Альберта Бандура")
    }

}
