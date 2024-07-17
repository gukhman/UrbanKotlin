fun main() {
    println("1."); GenericLim1().task(); println("----------------------------------")
    println("2."); GenericLim2().task(); println("----------------------------------")
}

/*1. Создать обобщенный класс States, который содержит функцию getAverage(),
возвращающую среднее значение массива чисел. Класс имеет ограничение,
работать может только с числовыми значениями, T:Number.*/
private class GenericLim1 {
    fun task() {
        val state1 = States(arrayListOf(112456.3, 2, 3.5, 4, 5.6345))
        val state2 = States(arrayListOf(-0.3, 2, 3, -7894564, 0))
        println("Среднее значение элементов массива: ${state1.getAverage()}")
        println("Среднее значение элементов массива: ${state2.getAverage()}")
    }

    class States<T : Number>(arr: ArrayList<T>) {
        val doubleArr = arr.map { elem -> elem.toDouble() } // любое T : Number приводится к Double
        fun getAverage(): Double = doubleArr.sum() / doubleArr.size
    }
}

/*2. Создать класс по имени GenericMethod и обобщенную функцию внутри класса
по имени isItIncluded(). Функция isItIncluded() определяет, является ли объект
членом массива. Он может быть использован с любым типом объектов и массивов
до тех пор, пока массив содержит объекты, совместимые с типом искомого объекта.*/
private class GenericLim2 {
    fun task() {
        val arr = GenericMethod(arrayListOf(11.3, 2, 3.5, 4, -5.634))
        var elem = 10
        if (arr.isItIncluded(elem)) println("\"$elem\" является элементом массива $arr") else println("\"$elem\" не входит в массив $arr")
        elem = 2
        if (arr.isItIncluded(elem)) println("\"$elem\" является элементом массива $arr") else println("\"$elem\" не входит в массив $arr")
    }

    class GenericMethod<T>(val arr: ArrayList<T>) {
        fun isItIncluded(elem: T): Boolean {
            return elem in arr
        }

        override fun toString(): String {
            var res = "["
            for (elem in arr) {
                res += "$elem, "
            }
            res = res.substring(0..res.length - 3) + "]"  //удалим ", " в конце строки и закроем скобку
            return res
        }
    }
}
















