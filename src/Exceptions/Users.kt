data class Users(val name: String, val seat: Int){
    override fun toString(): String {
        return "$seat: $name"
    }
}