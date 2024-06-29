class Box(private var width: Double, private var height: Double, private var depth: Double) {

    fun getVolume(): Double {
        return width * height * depth
    }
}