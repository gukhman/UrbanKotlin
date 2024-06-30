open class Smartphone {
    var name = ""
    var osType = ""
    open fun call() {
        println("☎ Осуществляется вызов...")
    }
}

open class Iphone : Smartphone() {
    var touchScreen = true
    var appStore = "App Store"
    override fun toString(): String {
        var res = "$name\n\tпод упралением $osType\n\t\t "
        if (touchScreen) res += "с сенсорным экраном "
        res += "и магазином приложений $appStore"
        return res
    }
}

class Nokia : Iphone() {
    override fun call() {
        super.call()
        println("Номер набирается на физической клавиатуре")
    }
}

class Sony : Iphone() {
    override fun call() {
        super.call()
        println("Номер набирается на сенсорном экране")
    }
}