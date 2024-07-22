/*Создать каталог пользователей вместимостью не более 10 персон.
Она будет содержать функцию приветствия greeting().
Необходимо написать функцию createList(list: Array<String>), в которой нужно
вводить имя и фамилию, предлагать пользователю разместить созданного члена каталога
на ту или иную позицию в каталоге list. Помещать его туда.
Программа должна перехватывать исключения на ввод пустого имени и определения места в каталоге,
которого не существует. Как пожелание, предлагаю написать свой класс исключений, например, с названием MyException.*/
fun main() {
    val users = ArrayList<Users>()
    print("Введите имена будущих членов клуба через запятую\n:")
    val names = readln()
    try {
        val usersToAdd = checkNames(names)
        usersToAdd.forEach { name ->
            val newUser = Users(name)
            users.add(newUser)
        }
    } catch (e: Exception) {
        println(e.message)
    }
    when (users.size) {
        in 1..10 -> greeting(users)
        0 -> println("Клуб не существует без членов клуба")
        else -> println("Членство в клубе могут получить только 10 гостей")
    }
}

fun checkNames(input: String): List<String> {
    val names = input.split(",")
    names.forEach { name ->
        if (name.isBlank()) throw Exception("Ни одно из введенных имён не должно быть пустым")
    }
    return names
}

fun greeting(users: ArrayList<Users>) {
    println("$users\nПриветствуем Вас в нашем клубе")
}