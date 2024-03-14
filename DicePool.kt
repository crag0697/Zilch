package zilch

class DicePool {

    // Establish properties to hold the dice pool and results as well as counts for each value
    var pool: MutableList<Die> = mutableListOf()
    var results: MutableList<Int> = mutableListOf()
    var counts: MutableList<Int> = MutableList(6) { 0 }

    // Create a pool of n dice based on how many dice the user is rolling
    fun setPool(length: Int) {
        for (i in 1..length) {
            val die = Die()
            pool.add(die)
        }
    }

    // Roll all dice in the current pool and add them to the results list
    fun rollDice() {
        for (die in pool) {
            results.add(die.roll())
        }
    }

    // Get counts for each value in the dice pool to verify scoring choices
    fun getCounts() {
        for (value: Int in results) {
            when (value) {
                1 -> counts[0]++
                2 -> counts[1]++
                3 -> counts[2]++
                4 -> counts[3]++
                5 -> counts[4]++
                6 -> counts[5]++
            }
        }
    }


}