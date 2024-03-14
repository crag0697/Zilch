package zilch

import java.util.*

fun main() {
    println("Welcome to Zilch")

    // Set up the player
    val player1 = Player()
    player1.player()

    // Display the main menu to the user.
    println("Menu")
    println("1. Start a new game")
    println("2. Exit game")
    println("Select a choice from the menu: ")

    // Simulating user input using readLine() for choice
    val choice = readlnOrNull()?.toIntOrNull() ?: 0

    when (choice) {
        1 -> {
            // Establish the current dice pool
            var length = 6
            var done = false
            while (!done && player1.playerScore < 5000) {
                val currentRoll = DicePool()
                currentRoll.setPool(length)
                currentRoll.rollDice()
                currentRoll.getCounts()

                // Calculate and add points to player's score
                player1.addPoints(currentRoll)
                player1.displayScore()

                if (player1.playerScore >= 5000) {
                    done = true
                } else {
                    println("Would you like to 'continue' with your current pool, 'reset' your dice, or 'quit' the game? ")
                    val reset = readlnOrNull()
                    when (reset?.lowercase(Locale.getDefault())) {
                        "continue" -> {
                            length = currentRoll.results.size
                        }

                        "reset" -> {
                            length = 6
                        }

                        "quit" -> {
                            done = true
                        }

                        else -> {
                            println("Invalid option. Please choose 'continue', 'reset', or 'quit'.")
                        }
                    }
                }
            }
        }
        2 -> {
            println("Exiting the game. Goodbye!")
        }
        else -> {
            println("Invalid choice. Exiting the game. Goodbye!")
        }
    }
}