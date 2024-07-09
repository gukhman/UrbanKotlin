abstract class Printer(val type: String, val model: String) {
    abstract fun toPrint()
    abstract fun info()
}