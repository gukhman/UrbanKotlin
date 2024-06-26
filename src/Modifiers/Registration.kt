class Registration {
    private val email = "test@example.com"
    private var password = "***"

    fun getEmail() {
        println("\t${email.uppercase()}")
    }

    fun setPassword() {
        print("Введите пароль:")
        val password = readln()
        if (password.length < 6) println("\tИспользуйте пароль длиной от 6 символов")
    }
}
