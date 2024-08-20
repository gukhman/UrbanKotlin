import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    println("1."); Coroutine1().task(); println("----------------------------------")
}

/*1. Написать программу покупки продукта в магазине. Она запускается с фразы "Программа покупки продуктов".
Далее через секундную задержку предлагает оплатить товар: "Купить товар:\n1.Да\n2.Нет".
Если да, то запускается корутина, в которой идет процесс оплаты:
"Оплата продукта началась"-> через 2 сек -> "Сканирование и обработка..." -> через 2 сек ->"Покупка оплачена."
Если нет, то запускается корутина отмены оплаты:
"Отмена покупки..." -> через 2 сек ->"Покупка отменена."
В любом другом случае – выходит ошибка.
Написать корутину, которая отвечает за окончание работы и выводит сообщение "До свидания".
Она может запускаться при любом вышеуказанном исполнении программы в конце.*/
private class Coroutine1 {
    suspend fun task() = coroutineScope {
        println("Программа покупки продуктов")
        delay(1000L)
        println("Купить товар:\n1.Да\n2.Нет")
        val choice = readln()
        lateinit var tasks: Job
        when (choice) {
            "1" -> {
                tasks = launch { pay() }
                tasks.join()
            }

            "2" -> {
                tasks = launch { reversal() }
                tasks.join()
            }

            else -> println("Некорректный выбор")
        }
        launch { bye() }
    }

    private suspend fun pay() {
        println("Оплата продукта началась")
        delay(2000L)
        println("Сканирование и обработка...")
        delay(2000L)
        println("Покупка оплачена.")
    }

    private suspend fun reversal() {
        println("Отмена покупки...")
        delay(2000L)
        println("Покупка отменена.")
    }

    private suspend fun bye() {
        delay(1000L)
        println("До свидания")
    }
}