interface TextClear {
    fun clearText(text: String) : String {
        var temp = text.trim()
        var rem = 0
        while (rem == 0) {
            for (i in temp.indices) {
                when (temp[i]) {
                    ",".toCharArray()[0] -> {
                        rem = 1;break
                    }

                    ".".toCharArray()[0] -> {
                        rem = 2;break
                    }

                    "(".toCharArray()[0] -> {
                        rem = 3;break
                    }

                    ")".toCharArray()[0] -> {
                        rem = 4;break
                    }

                    "–".toCharArray()[0] -> {
                        rem = 5;break
                    }
                }
            }
            if (rem == 0) break
            when (rem) {
                1 -> temp = temp.replace(",", " ")
                2 -> temp = temp.replace(".", " ")
                3 -> temp = temp.replace("(", " ")
                4 -> temp = temp.replace(")", " ")
                5 -> temp = temp.replace("–", " ")
            }
            rem = 0
        }
        return temp
    }
}