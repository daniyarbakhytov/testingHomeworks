@file:Suppress("UNUSED_EXPRESSION")

import io.kotlintest.matchers.numerics.shouldBeLessThan
import io.kotlintest.shouldBe
import io.kotlintest.specs.DescribeSpec
import java.util.*

class Homework : DescribeSpec({
    describe("Checks on Kotlin basics implementations") {
        context("functions") {
            val c = 5
            it("Multiple maps:") {
                multipleConditions(c) shouldBe "OK"
            }
        }

        context("collections") {
            it("Multiple conditions:") {
                val b = "foo"
                coldest(b) shouldBe 1
            }
        }

        context("sorted massive") {
            it("Operations:") {
                var massive = arrayOf(4,5,7,6,13,2)
                print(Arrays.toString(sortingMassive(massive)))
                isArraySorted(massive) shouldBe true


            }
        }

    }
})


fun multipleConditions(score: Int): String {
    return when (score) {
        9, 10 -> "try"
        in 6..8 -> "catch"
        4, 5 -> "OK"
        in 1..3 -> "bring"
        else -> "Fail"
    }
}

fun coldest(collect: String): Int? {
    val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
    // val c: Int? =
    return readWriteMap[collect]
}

fun sortingMassive(mas: Array<Int>): Array<Int>{
    for(i in 0 until (mas.size-1)) {
        for (j in 0 until (mas.size - i - 1)) {
            if (mas[j] > mas[j + 1]) {
                val tmp = mas[j]
                mas[j] = mas[j + 1]
                mas[j + 1] = tmp
            }
        }
    }
    return mas
}

fun isArraySorted(arr: Array<Int>): Boolean {
    for(i in 0 until arr.size-1) {
        if (arr[i] > arr[i + 1]) false
    }
    return true
}
