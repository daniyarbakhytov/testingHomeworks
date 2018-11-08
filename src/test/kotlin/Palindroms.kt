import io.kotlintest.shouldBe
import io.kotlintest.specs.DescribeSpec

class Palindroms : DescribeSpec({
    describe("Fifth Homework") {
        context("Palindrom") {
            it("testing palindrom") {
                val wordToRotate = "-7887-"
                val rotatedWord = rotating(wordToRotate)
                println()
                println(rotatedWord)
                firstMethodOfCheckingRotation(wordToRotate,rotatedWord) shouldBe true
                secondMethodOfCheckingRotation(wordToRotate, rotatedWord) shouldBe true
            }
        }
    }
})


fun firstMethodOfCheckingRotation(primaryWord: String, finalWord: String): Boolean {
    if(primaryWord.compareTo(finalWord)!=0){
        return false
    }
    return true
}

fun secondMethodOfCheckingRotation(primaryWord: String, finalWord: String):Boolean {
    val firstComparingWord = primaryWord.toCharArray()
    val secondComparingWord = finalWord.toCharArray()
    val length = firstComparingWord.size
    var count = 0
    if(firstComparingWord.size == secondComparingWord.size){
        for(i in 0 until length-1){
            if (firstComparingWord[i]==secondComparingWord[i])
                count++
        }
    }
    if (count == length-1) {
        return true
    }
    return false
}

fun reversing(str: CharArray, start: Int, end: Int) {
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

fun rotating(primary: String): String{
    val final = primary.toCharArray()
    var offset = final.size/2
    val length = final.size
    offset %= length
    reversing(final, 0, length - 1)
    return String(final)
}