data class CinemaTickets(val title: String, val seatNum: Int, val dateTime: String) {
    private var cinema = title
    private var date = dateTime
    private var seat = 0
    private var prevCinema = ""

    fun ticketFill(): CinemaTickets {
        var temp: String
        var exit = false
        var seatStr: String
        loop@ while (true) {
            if (date != "") prevCinema =
                ", сеанс $date"       //передана дата/время сеанса из предыдущего проданного билета
            if (cinema != "") {                                //передано название фильма из предыдущего проданного билета
                prevCinema = "фильм $cinema$prevCinema"
                println("Продажа билета на $prevCinema ")
            } else {
                print("Введите название фильма: ")
                temp = readlnOrNull().toString()
                if (exitCheck(temp)) {      //если при продаже билета хотим выйти из ПО
                    exit = true
                    break@loop
                } else cinema = temp
            }
            when (cinema) {
                "" -> println("Пустой ввод недопустим")
                else -> while (true) {
                    print("Введите номер места: ")
                    temp = readlnOrNull().toString()
                    if (exitCheck(temp)) {
                        exit = true
                        break@loop
                    } else seatStr = temp
                    when (seatStr) {
                        "" -> println("Пустой ввод недопустим")
                        //место - это число. Проверяем на NULL и проверяем что оно лежит в диапазоне 1..9999, если ввод некорректный то начинаем ввод заново
                        else -> if (seatStr.toIntOrNull() != null && seatStr.toIntOrNull()!! in 1..9999) {
                            seat = seatStr.toIntOrNull()!!
                            while (true) {
                                if (date == "") {
                                    print("Введите дату и время сеанса: ")
                                    temp = readlnOrNull().toString()
                                    if (exitCheck(temp)) {
                                        exit = true
                                        break@loop
                                    } else date = temp
                                }
                                when (date) {
                                    "" -> println("Пустой ввод недопустим")
                                    else -> break@loop
                                }
                            }
                        } else {
                            println("Некорректный ввод\n")
                            continue
                        }
                    }
                }
            }
        }
        //если хотим выйти из программы то передаем определенные значения параметров
        return if (exit) CinemaTickets("", 0, "") else CinemaTickets(cinema, seat, date)
    }

    private fun exitCheck(data: String): Boolean {
        val res = when (data) {
            "exit", "учше" -> true
            else -> false
        }
        return res
    }

    fun showSoldTickets(tickets: ArrayList<CinemaTickets>) {
        if (tickets.size > 0) {
            var res =
                "Проданные билеты:\nФильм\t\t\t\t\tМесто\tНачало сеанса\n"        //\t используются для форматирования вывода в виде таблицы
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
                res += when (ticket.seatNum) {
                    in 1..999 -> "\t\t"
                    else -> "\t"
                }
                res += "${ticket.dateTime}\n"
            }
            println(res)
        } else println("Еще не продано ни одного билета\n")
    }
}

