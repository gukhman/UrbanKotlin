fun main() {
    println("1."); task1(); println("----------------------------------")
    println("2."); task2(); println("----------------------------------")
    println("3."); task3(); println("----------------------------------")
}

/*1. Создать суперкласс Animal(животное) со свойствами веса и имени. Написать функцию, которая описывает прием пищи животного.
Наследовать от него подклассы Dog, Cat, используя все возможности суперкласса. У каждого животного определить по одной своейфункции.*/
private fun task1() {
    val dog = Dog()
    dog.name = "Дизель"
    dog.type = "Сенбернар"
    dog.weight = 80
    println(dog.toString())
    dog.omnomnom()
    dog.makeSound()

    println()

    val cat = Cat()
    cat.name = "Полосач"
    cat.type = "Оцелот"
    cat.weight = 14
    println(cat.toString())
    cat.omnomnom()
    cat.makeSound()
}

/*2. Создать классы Nokia и Sony. Наследовать каждый из них от суперклассов Smartphone и IPhone.
Создать несколько свойств в суперклассах и функцию звонка.*/
private fun task2() {
    val n3310 = Nokia()
    n3310.name = "Nokia 3310"
    n3310.osType = "Symbian OS"
    n3310.touchScreen = false
    n3310.appStore = "Ovi Store"
    println(n3310.toString())
    n3310.call()

    println()

    val xperia = Sony()
    xperia.name = "Sony Xperia 1"
    xperia.osType = "Android"
    xperia.touchScreen = true
    xperia.appStore = "Google play"
    println(xperia.toString())
    xperia.call()
}

/*3. Дан массив целых чисел 3, 67, 1, 55, 65, 89, 23. Вывести на экран
элементы массива, которые делятся на 5 на цело.*/
private fun task3() {
    val arr = arrayOf(3, 67, 1, 55, 65, 89, 23)
    print("Исходный массив: ${arr.joinToString(" ")}" +
            "\nЭлементы, делящиеся на 5 без остатка: ")
    for (i in arr) if (i % 5 == 0) print("$i ")
    println()
}
