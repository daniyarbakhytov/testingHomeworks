import io.kotlintest.shouldBe
import io.kotlintest.specs.DescribeSpec

class Homework4 : DescribeSpec({
    describe("Fourth Homework") {
        context("Operations on String type") {
            it("testing unique letters") {
                val letters = "hdbvwkhv"
                val lettersUniqued = unique(letters)
                println(lettersUniqued)
                unique(letters) shouldBe "hdbvwk"
                isUnique(letters, lettersUniqued) shouldBe true
            }
        }

        context("Rotate") {
            it("testing rotation") {
                val wordToRotate = "abcdef"
                val rotatedWord = rotatingWord(wordToRotate)
                println()
                println(rotatedWord)
                rotationCheck(wordToRotate,rotatedWord) shouldBe true
            }
        }
    }
})


fun rotationCheck(primaryWord: String, finalWord: String): Boolean {
    if(primaryWord.length!=finalWord.length){
        return false
    }
    val complex: String = primaryWord + primaryWord

    if(complex.indexOf(finalWord) != -1){
        return true
    }
    return false
}

fun reverse(str: CharArray, start: Int, end: Int) {
    var start = start
    var end = end
    while (start < end) {
        val temp = str[start]
        str[start] = str[end]
        str[end] = temp
        start++
        end--
    }
}

fun rotatingWord(primary: String): String{
    val final = primary.toCharArray()
    var offset = 3
    val length = final.size
    offset %= length
    reverse(final, 0, length - offset - 1)
    reverse(final, length - offset, length - 1)
    reverse(final, 0, length - 1)
    return String(final)
}

fun unique(str: String): String {

    var temp = ""

    for (i in 0 until str.length) {
        if (temp.indexOf(str[i]) == -1) {
            temp += str[i]
        }
    }
    return temp
}

fun isUnique(primary: String, final:String): Boolean{
    val primaryUnique = unique(primary)
    var b = primaryUnique == final
    return b
}
