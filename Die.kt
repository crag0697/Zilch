package zilch
import kotlin.random.Random

class Die {

    // Make a property to store the value of a roll
    var result: Int = 0

    fun roll(): Int {
        result = Random.nextInt(1, 7)
        return result
    }


}