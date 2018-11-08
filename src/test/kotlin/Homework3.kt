/* import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.DescribeSpec
import kotlin.collections.ArrayList

class Homework3 : DescribeSpec({
    describe("Second Homework") {
        context("release objects ") {
            it("release be in time checking") {

                var objectsToRelease = mapOf(1 to "registration", 3 to "redesign",4 to "addButton", 5 to "addCheckList",2 to "findErrors",6 to "endFinding")
                var keyList = objectsToRelease.keys.toIntArray()
                val quality = QA1()
                val develop = Developer1()
                println(keyList)
                var objectsToRelease1 = Map<Int, String>()

                develop.work1(2, objectsToRelease) // еще 2 задачи добавляются = 8
                /*quality.releaseTesting1(4.0, objectsToRelease) shouldBe true // успеют за 4 дня 8 задач
                quality.releaseTesting1(3.0, objectsToRelease) shouldBe false // не успеют за 3 дня 8 задач
                quality.work1(2, objectsToRelease) // еще 2 добавляются = 10
                quality.releaseTesting1(4.0, objectsToRelease) shouldBe false // не успеют за 4 дня 10 задач
                quality.releaseTesting1(5.0, objectsToRelease) shouldBe true // успеют за 5 дня 10 задач
                develop.work1(2, objectsToRelease) // сокращение на 2 задачи = 8
                quality.releaseTesting1(4.0, objectsToRelease) shouldBe true // успеют за 4 дня 8 задач
                quality.releaseTesting1(3.5, objectsToRelease) shouldNotBe true // не успеют за 3.5 дня 8 задач
                quality.work1(4, objectsToRelease1) // add to empty list
                quality.releaseTesting1(1.5, objectsToRelease1) shouldBe false // не успеют за полтора дня четыре задачи
                */
                println(keyList)

            }
        }
    }
})

fun <E> List<E>.getRandomElement(numberOfElements: Int): List<E>? {
    if (numberOfElements > this.size) {
        return null
    }
    return this.shuffled().take(numberOfElements)
}

open class Engineer1 {
    var name:String = ""
    var department: String = ""
    open fun work1(capacity: Int, currentTasks: Map<Int, String>) {}

    fun releaseTesting1(dateRelease: Double, objectsToRelease: Map<Int, String> ): Boolean {
        var keyList = objectsToRelease.keys.toIntArray()
        var hours = keyList.sum()
        val limit: Double = (hours / 2).toDouble()
        return dateRelease >= limit
    }
}

class QA1 :Engineer1(){

    override fun work1(capacity: Int, currentTasks: Map<Int, String>){
        var extraTasks = mapOf(8 to "zeroMemory", 7 to  "fullMemory", 11 to  "findException", 10 to "addTextView", 12 to "addEditText")
        var keyOfTasks = extraTasks.keys.toIntArray()
        var keyList = currentTasks.keys.toIntArray()
        var randomPick = keyOfTasks.getRandomElement(capacity)!!
        keyList.add(randomPick)
    }
}

private fun <E> ArrayList<E>.add(element: List<E>) {

}

class Developer1: Engineer1() {
    override fun work1(capacity: Int, currentTasks: Map<Int, String>) {
        var keyList = ArrayList(currentTasks.keys)
        for (i in keyList.size-1 downTo keyList.size - capacity) {
            keyList.removeAt(i)
        }
    }
}
*/