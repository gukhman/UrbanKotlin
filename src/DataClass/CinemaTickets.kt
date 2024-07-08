data class CinemaTickets(val title: String, val seatNum: String, val dateTime: String) {

    fun ticketFill(): CinemaTickets {
        var cinema = title
        var seat = seatNum
        var date = dateTime
        var prevCinema = ""

        loop@ while (true) {
            if (cinema != "") prevCinema = "фильм $cinema"
            if (date != "") prevCinema += ", сеанс $date"
            if (cinema == "") {
                print("Введите название фильма: ")
                cinema = inputChecks(readlnOrNull().toString())
            } else println("Продажа билета на $prevCinema ")
            when (cinema) {
                "" -> println("Пустой ввод недопустим")
                "q" -> break@loop
                else -> {
                    while (true) {
                        print("Введите номер места: ")
                        seat = inputChecks(readlnOrNull().toString())
                        when (seat) {
                            "" -> println("Пустой ввод недопустим")
                            "q" -> break@loop
                            else -> {
                                while (true) {
                                    if (date == "") {
                                        print("Введите дату и время сеанса: ")
                                        date = inputChecks(readlnOrNull().toString())
                                    }
                                    when (date) {
                                        "" -> println("Пустой ввод недопустим")
                                        else -> break@loop
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return CinemaTickets(cinema, seat, date)
    }

    private fun inputChecks(data: Any): String {
        val res: String = when (data) {
            "exit", "учше" -> "q"
            else -> data.toString()
        }
        return res
    }

    fun showSoldTickets(tickets: ArrayList<CinemaTickets>) {
        if (tickets.size > 0) {
            var res = "Проданные билеты:\nФильм\t\t\t\t\tМесто\tНачало сеанса\n"
            for (ticket in tickets) {
                res += ticket.title
                when (ticket.title.length) {
                    in 1..3 -> res += "\t\t\t\t\t\t"
                    in 4..7 -> res += "\t\t\t\t\t"
                    in 8..11 -> res += "\t\t\t\t"
                    in 12..15 -> res += "\t\t\t"
                    in 16..19 -> res += "\t\t"
                    in 20..23 -> res += "\t"
                }
                res += ticket.seatNum
                when (ticket.seatNum.length) {
                    in 1..3 -> res += "\t\t"
                    in 4..7 -> res += "\t"
                }
                res += "${ticket.dateTime}\n"

            }
            println(res)
        } else println("Еще не продано ни одного билета\n")
    }

}

