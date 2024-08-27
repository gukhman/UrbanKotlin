import kotlinx.coroutines.*
import kotlin.random.Random

suspend fun main() {
    println("1."); DispatcherAndCancel1().task(); println("----------------------------------")
}

private class DispatcherAndCancel1 {
    suspend fun task() = coroutineScope {
        val personManager = PersonManager()
        var readDataAndExit = false

        println("Программа работы с базой данных сотрудников")
        delay(1000L)

        while (!readDataAndExit) {
            println("Добавить сотрудника:\n1.Да\n2.Прочитать базу данных")
            val input = readlnOrNull()

            when (input) {
                "1" -> {
                    print("Введите имя сотрудника: ")
                    val name = readlnOrNull() ?: "Сотрудник Х"

                    print("Введите зарплату сотрудника: ")
                    val salary = readlnOrNull()?.toIntOrNull() ?: 50_000

                    val person = Person(name, salary)
                    personManager.addPerson(person)
                }

                "2" -> readDataAndExit = true
                else -> println("Неверный ввод, попробуйте снова.")
            }
        }

        val personManagerJob = async {
            personManager.addPassword()
            personManager.readDataPersonList()
            println("\nПрограмма завершила свою работу. Нажмите Enter для выхода")
        }

        async {
            while (!personManagerJob.isCompleted) {
                val input = readlnOrNull()
                if (input == "0") {
                    println("Завершение полной работы")
                    personManagerJob.cancel()
                    cancel()
                    break
                }
            }
        }
    }

    class PersonManager {
        val personList = mutableListOf(
            Person("Василий", 98_000),
            Person("Екатерина", 270_000),
            Person("Ярослав", 390_000)
        )

        val resultList = mutableMapOf<Person, String>()

        fun addPerson(person: Person) = personList.add(person)

        suspend fun addPassword() {
            for (person in personList) {
                val password = generatePass()
                delay(500L)
                resultList[person] = password
                println("\tsuccessfully add password to ${person.name}")
            }
        }

        suspend fun readDataPersonList(): Boolean {
            resultList.forEach {
                delay(1000L)
                println("Сотрудник: ${it.key}; пароль: ${it.value}")
            }
            return true
        }

        fun generatePass(): String {
            var pass = ""
            var letter: String
            val alphabet = "abcdefghijklmnopqrstuvwxyz".toList()
            //для создания надежного пароля из 6 символов =) будем чередовать буквы и цифры
            for (i in 1..3) {
                val upper = Random.nextInt(0, 2)
                letter = alphabet[Random.nextInt(0, alphabet.size)].toString()
                if (upper == 1) letter = letter.uppercase()
                val num = Random.nextInt(0, 10)
                pass += letter + num
            }
            return pass
        }
    }

    data class Person(val name: String, val salary: Int)
}