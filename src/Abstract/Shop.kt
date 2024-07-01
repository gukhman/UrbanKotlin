import java.text.SimpleDateFormat
import java.util.*

abstract class Shop {
    var openTime = 9    //час открытия
    var closeTime = 20    //час открытия
    var type = "магазин"
    var storeTraffic = 0
    var website = ""

    open fun isOpen() {
        val currentDate = Date()
        val timeFormat = SimpleDateFormat("H", Locale.getDefault())
        val hourNow = timeFormat.format(currentDate).toInt()
        if (hourNow < openTime || hourNow > closeTime) println("Сейчас магазин закрыт") else println("Магазин открыт")
    }

    abstract fun whatType()
    abstract fun whatToSale()
}

class Magnit : Shop() {

    override fun whatType() {
        println("Это $type Магнит, работает с $openTime до $closeTime")
    }

    override fun whatToSale() {
        println("Продаем вообще всё. " +
                "\nВ день у нас более $storeTraffic покупателей. " +
                "\nПосмотрите наш сайт $website")
    }

}

class Pyaterochka : Shop(){
    override fun whatType() {
        println("Это $type Пятерочка, работает с $openTime до $closeTime")
    }

    override fun whatToSale() {
        println("Продаем булочку, картошку и велосипеды. " +
                "\nВ день у нас более $storeTraffic покупателей. " +
                "\nПосмотрите наш сайт $website\")")
    }

}