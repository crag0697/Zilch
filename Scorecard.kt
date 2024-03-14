package zilch

class Scorecard {
    // Create the property that will hold the player's score
    var score: Int = 0

    // Create the needed functions to score the different combinations
    // Triple values
    fun triple(dicePool: DicePool, target: Int): Boolean {
        // Set the count to track if there are enough instances for a triple combo
        var count = 0
        for (value in dicePool.results) {
            if (value == target) {
                count++
            } else {
                continue
            }
        }

        if (count == 3) {
            for (i in 1..3) {
                dicePool.results.remove(target)
            }
            return true
        } else {
            return false
        }
    }

    // Three of a kind
    fun tripleDouble(dicePool: DicePool): Boolean {
        var count = 0
        for (value in dicePool.counts) {
            if (value == 4) {
                count += 2
            } else if (value == 2) {
                count++
            }
        }

        return count == 3 // Return true if count is 3, otherwise return false
    }

    // Straight
    fun straight(dicePool: DicePool): Boolean {
        for (i in 0..<dicePool.counts.size) {
            if (dicePool.counts[i] != dicePool.counts[i + 1]) {
                return false // If any two consecutive elements are not equal, it's not a straight
            }
        }
        return true // If all elements are equal, it's a straight
    }

    // Yahtzee
    fun yahtzee(dicePool: DicePool): Boolean {
        for (i in 0..dicePool.counts.size) {
            if (dicePool.results[i] != dicePool.results[i+1]) {
                return false
            }
        }
        return true
    }

    fun calculateScore(dicePool: DicePool) {
        var choice: Int

        do {
            choice = 0
            println("Current Dice Pool: ${dicePool.results}")
            println("Select the score you would like to save:")
            println("1. 5 - 50 points")
            println("2. 1 - 100 points")
            println("3. Triple 2's - 200 points")
            println("4. Triple 3's - 300 points")
            println("5. Triple 4's - 400 points")
            println("6. Triple 5's - 500 points")
            println("7. Triple 6's - 600 points")
            println("8. Triple 1's - 1000 points")
            println("9. Two sets of 3 pairs - 1500 points")
            println("10. Straight(1-6) - 1500 points")
            println("11. Yahtzee(6 matching) - 2500 points")
            println("12. Finish Scoring")

            // Take user input for how they want to score
            val input = readLine()
            choice = input?.toIntOrNull() ?: 13

            when (choice) {
                1 -> {
                    if (5 in dicePool.results) {
                        dicePool.results.remove(5)
                        score += 50
                    } else {
                        println("Sorry, that value is not a part of your current dice pool. Please select a new scoring option or end your turn.")
                    }
                }
                2 -> {
                    if (1 in dicePool.results) {
                        dicePool.results.remove(1)
                        score += 100
                    } else {
                        println("Sorry, that value is not a part of your current dice pool. Please select a new scoring option or end your turn.")
                    }
                }
                3 -> {
                    if (triple(dicePool, 2)) {
                        score += 200
                    } else {
                        println("Sorry, that value is not a part of your current dice pool. Please select a new scoring option or end your turn.")
                    }
                }
                4 -> {
                    if (triple(dicePool, 3)) {
                        score += 300
                    } else {
                        println("Sorry, that value is not a part of your current dice pool. Please select a new scoring option or end your turn.")
                    }
                }
                5 -> {
                    if (triple(dicePool, 4)) {
                        score += 400
                    } else {
                        println("Sorry, that value is not a part of your current dice pool. Please select a new scoring option or end your turn.")
                    }
                }
                6 -> {
                    if (triple(dicePool, 5)) {
                        score += 500
                    } else {
                        println("Sorry, that value is not a part of your current dice pool. Please select a new scoring option or end your turn.")
                    }
                }
                7 -> {
                    if (triple(dicePool, 6)) {
                        score += 600
                    } else {
                        println("Sorry, that value is not a part of your current dice pool. Please select a new scoring option or end your turn.")
                    }
                }
                8 -> {
                    if (triple(dicePool, 1)) {
                        score += 1000
                    } else {
                        println("Sorry, that value is not a part of your current dice pool. Please select a new scoring option or end your turn.")
                    }
                }
                9 -> {
                    if (tripleDouble(dicePool)) {
                        score += 1500
                        dicePool.results.clear()
                    } else {
                        println("Sorry, that value is not a part of your current dice pool. Please select a new scoring option or end your turn.")
                    }
                }
                10 -> {
                    if (straight(dicePool)) {
                        score += 1500
                        dicePool.results.clear()
                    }
                }
                11 -> {
                    if (yahtzee(dicePool)) {
                        score += 2500
                        dicePool.results.clear()
                    }
                }
            }
        } while (choice != 12)
    }
}