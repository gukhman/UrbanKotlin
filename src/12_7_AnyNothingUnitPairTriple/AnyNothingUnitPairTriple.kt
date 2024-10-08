fun main() {
    println("1."); AnyNothingUnitPairTriple1().task(); println("----------------------------------")
    println("2."); AnyNothingUnitPairTriple2().task(); println("----------------------------------")
}

/*1. Дана строка из скобок "{([])}". Проверить наличие у каждой открывающейся скобки на своей позиции –
закрывающейся на своей, соблюдая принцип «симметричности». Т.е. в данном случае при проверке программы
должно выйти true, т.к. соответствие прослеживается. Если допустим, строка будет такого плана
"{([))}","{{[])}» – это false.*/
private class AnyNothingUnitPairTriple1 {
    fun task() {
        //Скобки для проверки
        val scopesString = "{([({})])}"
        //Эталонные пары скобок
        val reference = listOf(Pair('(', ')'), Pair('[', ']'), Pair('{', '}'))

        var isSymmetric: Boolean
        if (scopesString.length % 2 != 0) {
            isSymmetric = false
        } else {
            val pairs = stringToPairs(scopesString)
            isSymmetric = true
            for (pair in pairs) {
                //println(pair)
                if (pair !in reference) isSymmetric = false
            }
        }
        if (isSymmetric) println("Скобки $scopesString симметричны") else println("Скобки $scopesString не симметричны")
    }

    fun stringToPairs(input: String): ArrayList<Pair<Char, Char>> {
        //найдем середину строки
        val mid = input.length / 2
        val half = arrayListOf<Char>()
        val pairs = arrayListOf<Pair<Char, Char>>()

        //Перевернем первую половину строки
        for (i in mid - 1 downTo 0) half.add(input[i])

        //Сформируем пары для дальнейшей проверки
        for (i in 0..<mid) pairs.add(Pair(half[i], input[i + mid]))
        return pairs
    }
}

/*2. Дан массив целых чисел val array = intArrayOf(1, 2, 3).
Вывести в консоль максимальное количество перестановок элементов массива.*/
private class AnyNothingUnitPairTriple2 {
    fun task() {
        val array = intArrayOf(4, 5, 7, 8)
        val permutations = arrayListOf<IntArray>()
        generatePermutations(array, 0, permutations)

        println("Максимальное количество перестановок элементов массива ${array.joinToString(", ", "[", "]")}: ${permutations.size}")
        permutations.forEach { println(it.joinToString(", ", "[", "]")) }
    }

    fun generatePermutations(array: IntArray, start: Int, permutations: ArrayList<IntArray>) {
        if (start == array.size - 1) {
            permutations.add(array.copyOf())
        } else {
            for (i in start..<array.size) {
                changeElements(array, start, i)
                generatePermutations(array, start + 1, permutations)
                changeElements(array, start, i) // Обратно меняем местами для восстановления исходного состояния
            }
        }
    }

    fun changeElements(arr: IntArray, i: Int, j: Int): IntArray {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
        return arr
    }
}