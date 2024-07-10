import kotlin.math.pow

interface Notation {
    fun decToBin(decimal: Int): String {
        if (decimal == 0) return "0"
        var num = decimal
        var res = ""
        var temp: Int
        while (num > 0) {
            temp = (num % 2)
            num /= 2
            res = temp.toString() + res
        }
        return res
    }

    fun binToDec(binary: String): Int {
        var num: Int
        var res = 0
        for (digit in binary.length - 1 downTo 0) {
            num = binary[binary.length - 1 - digit].toString().toInt()
            res += num * 2.0.pow(digit).toInt()
        }
        return res
    }

    fun decimalCheck(input: String): Boolean {
        val inputOK = input.toIntOrNull() != null && input.toIntOrNull()!! >= 0
        return inputOK
    }

    fun binaryCheck(input: String): Boolean {
        var temp = input
        val first = temp[0].toString()
        while (temp.contains("0")) temp = temp.replace("0","")
        while (temp.contains("1")) temp = temp.replace("1","")
        return ((first == "1" && temp == "") || input == "0")
    }
}