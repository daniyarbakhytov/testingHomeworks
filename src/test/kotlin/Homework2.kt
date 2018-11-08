import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.DescribeSpec
import kotlin.collections.ArrayList

class Homework2 : DescribeSpec({
    describe("Second Homework") {
        context("release objects ") {
            it("release be in time checking") {

                val objectsToRelease = arrayListOf("registration", "redesign", "addButton","addCheckList", "findErrors", "endFinding")

                val objectsToRelease1 = arrayListOf<String>()
                val quality = QA()
                val develop = Developer()
                quality.work(2, objectsToRelease) // еще 2 задачи добавляются = 8
                quality.releaseTesting(4.0, objectsToRelease) shouldBe true // успеют за 4 дня 8 задач
                quality.releaseTesting(3.0, objectsToRelease) shouldBe false // не успеют за 3 дня 8 задач
                quality.work(2, objectsToRelease) // еще 2 добавляются = 10
                quality.releaseTesting(4.0, objectsToRelease) shouldBe false // не успеют за 4 дня 10 задач
                quality.releaseTesting(5.0, objectsToRelease) shouldBe true // успеют за 5 дня 10 задач
                develop.work(2, objectsToRelease) // сокращение на 2 задачи = 8
                quality.releaseTesting(4.0, objectsToRelease) shouldBe true // успеют за 4 дня 8 задач
                quality.releaseTesting(3.5, objectsToRelease) shouldNotBe true // не успеют за 3.5 дня 8 задач
                quality.work(4, objectsToRelease1) // add to empty list
                quality.releaseTesting(1.5, objectsToRelease1) shouldBe false // не успеют за полтора дня четыре задачи
                println(objectsToRelease1)
                print(objectsToRelease)
            }
        }
    }
})

fun <E> List<E>.getRandomElements(numberOfElements: Int): List<E>? {
    if (numberOfElements > this.size) {
        return null
    }
    return this.shuffled().take(numberOfElements)
}

open class Engineer {
    var name:String = ""
    var department: String = ""
    open fun work(capacity: Int, currentTasks: ArrayList< String>) {}
    fun releaseTesting(dateRelease: Double, objectsToRelease: ArrayList<String> ): Boolean {
        val limit: Double = (objectsToRelease.size / 2).toDouble()
        return dateRelease >= limit
    }
}

class QA :Engineer(){

    override fun work(capacity: Int, currentTasks: ArrayList<String>){
        val extraTasks: List<String> = arrayListOf("zeroMemory", "fullMemory", "findException", "addTextView", "addEditText")
        val randomPick: List<String> = extraTasks.getRandomElements(capacity)!!
        currentTasks += randomPick
    }
}

class Developer: Engineer() {
    override fun work(capacity: Int, currentTasks: ArrayList<String>) {
        for (i in currentTasks.size-1 downTo currentTasks.size - capacity) {
            currentTasks.removeAt(i)
        }
    }
}
