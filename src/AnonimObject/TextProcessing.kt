interface TextProcessing {
    fun clearText(text: String): String {
        var newText = text.trim()
        for (symbol in newText) {
            when (symbol.toString()) {
                "|", "/", ":", "\"", ".", "(", ")", "!", "?", "*", "%", "^", "&", "$", "@" -> newText =
                    newText.replace(symbol.toString(), " ")
            }
        }
        return newText
    }
}