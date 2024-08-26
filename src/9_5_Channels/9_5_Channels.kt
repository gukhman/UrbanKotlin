import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlin.system.measureTimeMillis

suspend fun main() {
    println("1."); Channels1().task(); println("----------------------------------")
    println("2."); Channels2().task(); println("----------------------------------")
}

private class Channels1 {
    suspend fun task() = coroutineScope {
        val text = Storage().text.trim()
        val channel = Channel<String>()
        var stringResult = ""

        val time = measureTimeMillis {
            launch {
                getList(text, channel)
            }
            stringResult = buildString {
                for (line in channel) {
                    appendLine("\t$line")
                }
            }
        }

        println("Полученный результат:\n$stringResult")
        println("Время, затраченное на получение данных: $time ms")
    }
}

private class Channels2 {
    suspend fun task() = coroutineScope {
        val text = Storage().text.trim()
        val initialChannel = Channel<String>()
        val modifiedChannel = Channel<String>()
        var stringResult = ""

        val time = measureTimeMillis {
            launch {
                getList(text, initialChannel)
            }
            launch {
                modifiedList(initialChannel, modifiedChannel)
            }
            stringResult = buildString {
                for (line in modifiedChannel) {
                    appendLine("\t$line")
                }
            }
        }

        val listStringResult: List<String> = stringResult.split("\n").filter { it.isNotEmpty() }
        println("Полученный результат:\n$stringResult")
        println("Результат в виде списка: $listStringResult")
        println("Время, затраченное на получение данных и преобразования: $time ms")
    }
}

suspend fun modifiedList(inputChannel: Channel<String>, outputChannel: Channel<String>) {
    for (line in inputChannel) {
        val out = if (line.isNotEmpty()) line[0].uppercase() else line
        delay(10L)
        outputChannel.send(out)
    }
    outputChannel.close()
}

suspend fun getList(text: String, channel: Channel<String>) {
    val stringList = getStringList(text)
    for (line in stringList) {
        delay(10L)
        channel.send(line)
    }
    channel.close()
}

fun getStringList(text: String): List<String> = text.split("\n")

class Storage {
    val text: String = """
Мартышка к старости слаба глазами стала;
А у людей она слыхала,
Что это зло еще не так большой руки:
Лишь стоит завести Очки.
Очков с полдюжины себе она достала;
Вертит Очками так и сяк:
То к темю их прижмет, то их на хвост нанижет,
То их понюхает, то их полижет;
Очки не действуют никак.
«Тьфу пропасть! — говорит она, — и тот дурак,
Кто слушает людских всех врак;
Всё про Очки лишь мне налгали;
А проку на-волос нет в них».
Мартышка тут с досады и с печали
О камень так хватила их,
Что только брызги засверкали.

К несчастью, то ж бывает у людей:
Как ни полезна вещь, — цены не зная ей,
Невежда про неё свой толк все к худу клонит;
А ежели невежда познатней,
Так он её ещё и гонит.
"""
}