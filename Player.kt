package zilch

class Player {
    // Initialize all the properties of a player
    var name: String = ""
    var scorecard: Scorecard = Scorecard()
    var playerScore = 0

    fun player() {
        print("Please enter your name: ")
        name = readLine() ?: ""
        scorecard = Scorecard()
    }

    fun addPoints(dicePool: DicePool) {
        scorecard.calculateScore(dicePool)
        playerScore += scorecard.score
    }

    fun displayScore() {
        println("Current Score: $playerScore")
    }
}