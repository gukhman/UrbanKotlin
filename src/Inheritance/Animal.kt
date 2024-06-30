open class Animal {
    var name = ""
    var type = ""
    var weight = 0

    fun omnomnom() {
        println("Я кушаю, прошу не мешать. РРРР!")
    }
}

class Dog : Animal() {
    override fun toString(): String {
        return "Это пёс $name породы $type, вес $weight кг."
    }

    fun makeSound() {
        println("ВУФ-ВУФ!")
    }
}


class Cat : Animal() {
    override fun toString(): String {
        return "Это кот $name породы $type, вес $weight кг."
    }

    fun makeSound() {
        println("МЯУ-мяу, мррр-ррр.")
    }
}
