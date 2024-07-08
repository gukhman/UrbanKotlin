class Human(var name: String, var profession: String) {
    inner class head {
        fun think() {
            println("Мозговая активность")
        }

        fun thinkMore() : String {
            return "Мозговой штурм"
        }
    }

    inner class legs {
        fun move() {
            println("${profession}у по имени ${name} не помешает долгая прогулка после работы")
        }
    }
}