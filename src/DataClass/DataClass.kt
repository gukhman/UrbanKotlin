fun main() {
    DataClassTask1().task()
}

/*1.     Написать программу по продаже билетов в кино. Пользователь покупает билет, в который заносятся данные названия фильма,
места и времени начала сеанса. Проданные билеты заносятся в массив архива. По желанию можно вывести все проданные билеты на фильм.*/

private class DataClassTask1 {
    val soldTickets = ArrayList<CinemaTickets>()

    fun task() {
        while (true) {
            print(
                "Введите\n" +
                        "1 для продажи билета\n" +
                        "2 для продажи билета на тот же сеанс (надо ввести только место)\n" +
                        "3 для продажи билета на тот же фильм (надо ввести только место и сеанс)\n" +
                        "all для вывода всех проданных билетов\n" +
                        "----------------------------------\n" +
                        "Для выхода из программы введите exit.\n:"
            )
            val whatToDo = readlnOrNull().toString()
//            val whatToDo = "1"
            if (whatToDo != "") {   //действие
                when (whatToDo) {
                    "1", "2", "3" -> {
                        var title = ""
                        var dateTime = ""
                        if (whatToDo == "2") {      //1 -заполняем все, 2 заполняем только место, 3 - заполняем место и время
                            if (soldTickets.size > 0) {
                                title = soldTickets.last().title
                                dateTime = soldTickets.last().dateTime
                            } else println("Еще не продано ни одного билета\n")     //если это первая продажа то опции 2 и 3 не должны работать
                        } else if (whatToDo == "3") {
                            if (soldTickets.size > 0) {
                                title = soldTickets.last().title
                            } else println("Еще не продано ни одного билета\n")
                        }
                        val ticket = CinemaTickets(title, "", dateTime).ticketFill()    //заполняем билет
                        if (wannaExit(ticket)) break else {    //проверяем, нехочет ли пользователь выйти из ПО, если нет - добавляем заполненный билет в проданные
                            soldTickets.add(ticket)
                            println("Билет продан.\n")
                        }
                    }

                    "all", "фдд" -> {
                        CinemaTickets("", "", "").showSoldTickets(soldTickets)
                    }

                    "exit", "учше" -> break
                    else -> println("Некорректный ввод.\n")
                }
            } else {
                println("Пустой ввод недопустим\n")
                continue
            }
        }
    }

    fun wannaExit(ticket: CinemaTickets): Boolean {
        //проверяем, не была ли введена команда выхода из программы
        val ticketStr = "${ticket.title}~${ticket.seatNum}~${ticket.dateTime}~"
        return when (ticketStr.contains("q~")) {
            true -> true
            else -> false
        }
    }
}
