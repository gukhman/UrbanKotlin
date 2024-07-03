abstract class Bird(
    var type: String = "",
    open var flying: Boolean = true
){
    var weight = 0
    open fun makeSound() {
        println("$type издает свист")
    }
}

class Blackbirds(type: String = "Дроздовые", flying: Boolean = true) : Bird(type, flying){
    override fun toString(): String {
        return "$type красиво поет, хорошо летает и мало весит"
    }
}

class Penguins(type: String = "Пингвинообразные", override var flying: Boolean = false) : Bird(type, flying) {
    override fun makeSound() {
        println("Пингвины пищат")
    }
    override fun toString(): String {
        return "$type не летает, его вес составляет ококо ${weight/1000} кг."
    }
}

class Pelicans(type: String = "Пеликанообразные", flying: Boolean = true) : Bird(type, flying) {
    override fun makeSound() {
        println("Пеликаны ворчат")
    }
    override fun toString(): String {
        return "$type летают, его вес составляет ококо ${weight/1000} кг."
    }
}

class Flamingoformes(type: String = "Фламингообразные", flying: Boolean = true) : Bird(type, flying) {
    override fun makeSound() {
        println("Фламинго гогочат")
    }
    override fun toString(): String {
        return "$type летают, его вес составляет ококо ${weight/1000} кг."
    }
}