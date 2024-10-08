import kotlinx.coroutines.delay

suspend fun main() {
    println("Кофе в дорогу?")
    while (true) {
        print(
            "Выберите кофе\n" +
                    "1. Americano\n" +
                    "2. Cappuccino\n" +
                    "3. Latte\n" +
                    "Введите 0 для выхода: "
        )
        when (val coffeeType = readln()) {
            in arrayOf("1", "2", "3") -> {
                val sugar = addSugar()
                val volume = addVolume()
                when (coffeeType) {
                    "1" -> {
                        val americano = sugar?.let { volume?.let { it1 -> Coffee.Americano(it, it1) } }
                        americano?.let { selectedMenu(it) }
                    }

                    "2" -> {
                        val milk = addMilk()
                        val cappuccino = sugar?.let { s ->
                            volume?.let { v ->
                                milk?.let { m ->
                                    Coffee.Cappuccino(s, v, m)
                                }
                            }
                        }
                        cappuccino?.let { selectedMenu(it) }
                    }

                    "3" -> {
                        val latte = sugar?.let { volume?.let { it1 -> Coffee.Latte(it, it1) } }
                        latte?.let { selectedMenu(it) }
                    }
                }
            }

            "0" -> break
            else -> {
                println("Некорректный ввод")
                continue
            }
        }
    }
}

private suspend fun selectedMenu(menu: Coffee) {
    reading(menu.volume)
    println()
    println("Ваш кофе готов:\n$menu")
}

private suspend fun reading(volume: Int) {
    for (i in 1..10) {
        delay(volume.toLong())
        print("${i * 10}% ")
    }
}

private fun addSugar(): Int? {
    var sugar: Int?
    while (true) {
        print("Количество ложек сахара (0-4): ")
        sugar = readlnOrNull()?.toIntOrNull()
        if (sugar == null || sugar < 0 || sugar > 4) {
            println("Сахара не может быть меньше 0 и больше 4 ложек")
            continue
        }
        break
    }
    return sugar
}

private fun addVolume(): Int? {
    var volume: Int?
    while (true) {
        print("Объем кофе(20 - 300 мл): ")
        volume = readlnOrNull()?.toIntOrNull()
        if (volume == null || volume < 20 || volume > 300) {
            println("Объем кофе не может быть меньше 20 и больше 300 мл")
            continue
        }
        break
    }
    return volume
}

private fun addMilk(): Int? {
    var milk: Int?
    while (true) {
        print("Объем молока(0 - 100 мл): ")
        milk = readlnOrNull()?.toIntOrNull()
        if (milk == null || milk < 0 || milk > 100) {
            println("Объем молока не может быть меньше 0 и больше 1000 мл")
            continue
        }
        break
    }
    return milk
}