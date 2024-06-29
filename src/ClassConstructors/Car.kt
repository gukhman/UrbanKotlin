class Car(private var name: String, private var weight: Int, private var speed: Int) {

    fun move() {
        var res = "Автомобиль $name массой $weight кг "
        if (speed > 90) res += "быстро едет со скоростью $speed км/ч"
        else if (speed in 40..90) res += "едет со скоростью $speed км/ч"
        else if (speed == 0) res += "поедет как только загорится зеленый. Сейчас его скорость $speed км/ч"
        else res += "медленно едет со скоростью $speed км/ч"
        println(res)
    }

    fun stop() {
        var res = "Автомобиль $name массой $weight кг "
        if (speed > 0) res += "едет со скоростью $speed км/ч и останавливается"
        else if (speed == 0) res += "остановился, его скорость $speed км/ч"
        println(res)
    }
}