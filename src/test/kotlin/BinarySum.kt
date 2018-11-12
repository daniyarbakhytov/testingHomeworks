import io.kotlintest.shouldBe
import io.kotlintest.shouldEqual
import io.kotlintest.specs.DescribeSpec
import java.util.*

class BinarySum : DescribeSpec({
    describe("Six Homework") {
        context("sum of binaries") {
            it("testing sum") {
                val a = "101"
                val b = "110"
                val c = "00001011"
                var binaries = sumOfBinaries(a,b) // array of numbers of binary, array size in this method is 8
                var str = Arrays.toString(sumOfBinaries(a,b)) // convert to String
                str = str.replace(", ".toRegex(), "").replace("[", "").replace("]", "") // remove separates(", ", "]", "[")
                str shouldBe c
                binaries[4] shouldEqual 1
                binaries[7] shouldBe 1

            }
        }

        context("swap of integers") {

            it("testing swap") {
                var first = 12
                var second = 3
                var mas = swapOfInts(first, second) // array which consist swapped integers with sum of them
                var masWithTemp = swapWithTemp(first, second) // array which consist swapped integers with temp
                first = mas[0]
                second = mas[1]
                first shouldBe 3
                second shouldBe 12
                first shouldEqual masWithTemp[0]
                second shouldBe masWithTemp[1]
            }
        }
    }
})



fun sumOfBinaries(firstBinaryString: String, secondBinaryString: String): IntArray {
    var firstBinary = firstBinaryString.toInt()
    var secondBinary = secondBinaryString.toInt()
    var summary = IntArray(8)
    var first = 0
    var second = 0
    var remind = 0
    var sum = 0
    for (i in summary.size-1 downTo  0){
        first = firstBinary % 10
        second = secondBinary % 10
        firstBinary /= 10
        secondBinary /= 10
        sum = first + second + remind
        if(sum == 1){
            summary[i] = first + second + remind
            remind = 0
        }
        else if(sum == 2){
            summary[i] = 0
            remind = 1
        }
        else if(sum == 3){
            summary[i] = 1
            remind = 1
        }
        else{
            summary[i] = first + second + remind
        }
    }
    return summary
}

// swap через суммы обеих чисел
fun swapOfInts(a: Int, b: Int): Array<Int> {
    var a = a
    var b = b
    a += b
    b = a - b
    a -= b
    return arrayOf(a, b)

}

// swap через темп
fun swapWithTemp(a: Int, b: Int): Array<Int> {
    var a = a
    var b = b
    var temp = a
    a = b
    b = temp
    return arrayOf(a, b)
}
