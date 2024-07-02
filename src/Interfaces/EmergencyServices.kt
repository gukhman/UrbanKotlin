abstract class EmergencyServices(val name: String, val phone: String) {
    fun call() : String {
        return "Необходимо позвонить в $name по номеру $phone"
    }
}

interface GetDescription {
    fun getInfo()
}

class FireService : EmergencyServices("Пожарная охрана", "01"), GetDescription {
    override fun getInfo() {
        println("Это служба $name. Её номер $phone")
    }
    fun callToService() {
        println("Пожар! ${call()}")
    }
}

class Police : EmergencyServices("Полиция", "02"), GetDescription {
    override fun getInfo() {
        println("Это служба $name. Её номер $phone")
    }
    fun callToService() {
        println("Преступление! ${call()}")
    }
}

class Medical : EmergencyServices("Скорая помощь", "03"), GetDescription {
    override fun getInfo() {
        println("Это служба $name. Её номер $phone")
    }
    fun callToService() {
        println("Травма! ${call()}")
    }
}

class Gas : EmergencyServices("Аварийная газовая служба", "04"), GetDescription {
    override fun getInfo() {
        println("Это служба $name. Её номер $phone")
    }
    fun callToService() {
        println("Утечка газа! ${call()}")
    }
}