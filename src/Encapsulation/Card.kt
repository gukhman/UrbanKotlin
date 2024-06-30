class Card {
    var number = "0"
        get() {
            print("Для получения номера карты введите пароль: ")
            val input = readlnOrNull()
            return if (input == pass) field
            else "***. Пароль введен неправильно."
        }
    private val pass = "secret"
}