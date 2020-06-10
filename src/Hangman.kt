import kotlin.random.Random

val words = listOf("hippopotamus", "flounder", "incinerate", "abolish", "dysfunction", "patella", "hemoglobin", "neurophysiology", "truncate", "warble")
var word = ""
val guesses = arrayListOf<Char>()
var remainingGuesses = 6
var mistakes = 0

fun main() {
    setupGame()
}

fun setupGame() {
    val wordIndex = Random.nextInt(words.size)
    word = words[wordIndex].toUpperCase()
    println(word)

    for (i in word.indices)
        guesses.add('_')

    var gameOver = false

    do {
        printGameStatus()
        print("Please enter a letter: ")
        val input = readLine() ?: ""

        if (input.isEmpty()) {
            println("That's not a valid input. Please try again!")
        } else {
            val letter = input[0].toUpperCase()
            if (word.contains(letter)) {
                for (i in word.indices) {
                    if (word[i] == letter)
                        guesses[i] = letter
                }
                if (!guesses.contains('_'))
                    gameOver = true
            } else {
                println("Sorry, that's not part of the word")
                remainingGuesses--
                mistakes++
                if (mistakes == 6)
                    gameOver = true
            }
        }

    } while (!gameOver)

    if (mistakes == 6) {
        printGameStatus()
        println("Sorry you lost. The word was \n$word")
    } else {
        println("\n Congrats, you won!")
        println("The word was \n$word")
    }
}

fun printGameStatus() {
    when (mistakes) {
        0 -> print0Mistakes()
        1 -> print1Mistake()
        2 -> print2Mistakes()
        3 -> print3Mistakes()
        4 -> println4Mistakes()
        5 -> print5Mistakes()
        6 -> println6Mistakes()
    }

    print("Word: ")
    for (element in guesses)
        print("$element ")
    println("\nYou have $remainingGuesses guess(es) left")

}

fun print0Mistakes() {
    println("  |______|_")
    println("  |      | ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")

}

fun print1Mistake() {
    println("  |______|_")
    println("  |      | ")
    println("  |      0 ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print2Mistakes() {
    println("  |______|_")
    println("  |      | ")
    println("  |      0 ")
    println("  |      | ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print3Mistakes() {
    println("  |______|_")
    println("  |      | ")
    println("  |      0 ")
    println("  |     /|  ")
    println("  |      |  ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun println4Mistakes() {
    println("  |______|_")
    println("  |      | ")
    println("  |      0 ")
    println("  |     /|\\  ")
    println("  |      |  ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print5Mistakes() {
    println("  |______|_")
    println("  |      | ")
    println("  |      0 ")
    println("  |     /|\\  ")
    println("  |      |  ")
    println("  |     /   ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun println6Mistakes() {
    println("  |______|_")
    println("  |      | ")
    println("  |      0 ")
    println("  |     /|\\  ")
    println("  |      |  ")
    println("  |     / \\  ")
    println(" /|\\      ")
    println("/ | \\     ")
}