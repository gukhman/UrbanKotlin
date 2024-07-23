import kotlin.system.exitProcess

/*Создать каталог пользователей вместимостью не более 10 персон.
Она будет содержать функцию приветствия greeting().
Необходимо написать функцию createList(list: Array<String>), в которой нужно
вводить имя и фамилию, предлагать пользователю разместить созданного члена каталога
на ту или иную позицию в каталоге list. Помещать его туда.
Программа должна перехватывать исключения на ввод пустого имени и определения места в каталоге,
которого не существует. Как пожелание, предлагаю написать свой класс исключений, например, с названием MyException.*/
fun main() {
    val users = arrayOfNulls<Users>(10)
    while (listOfNotNull(users).isNotEmpty()) {
        print("Введите имя нового члена клуба(0 - для выхода): ")
        val name = readln()
        if (name == "0") {
            greeting(users)
            exitProcess(0)
        }
        print("Введите место нового члена клуба: ")
        val seat = readln()
        try {
            val intSeat = checkNameSeat(name, seat, users)
            val newUser = Users(name, intSeat)
            users[intSeat - 1] = newUser
        } catch (e: Exception) {
            println(e.message)
        }
        greeting(users)
    }
}

fun checkNameSeat(name: String, seat: String, users: Array<Users?>): Int {
    if (name.isBlank()) throw Exception("Имя не должно быть пустым")
    var emptySeat = ""
    for (i in users.indices) if (users[i] == null) emptySeat += "${i + 1}, "
    val intSeat = seat.toIntOrNull()
    when (intSeat) {
        null -> throw Exception("В клубе 10 мест. Нужно ввести число от 1 до 10")
        !in 1..10 -> throw Exception("Количество мест ограничено 10 членами клуба. Нужно ввести число от 1 до 10")
        else -> if (users[intSeat - 1] != null) throw Exception("Место $intSeat уже занято, свободные места: $emptySeat")
    }
    return intSeat
}

fun greeting(users: Array<Users?>) {
    var nulls = 0
    for (i in users.indices) if (users[i] == null) nulls++
    if (nulls < users.size) {
        users.forEach { user ->
            if (user != null) println("$user, приветствуем Вас в нашем клубе")
        }
    } else println("Клуб не существует без членов клуба")
}
