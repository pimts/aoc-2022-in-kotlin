fun main() {

    fun part1(input: List<String>): Int {
        /*
            A = X = ROCK = 1
            B = Y = PAPER = 2
            C = Z = SCISSORS = 3
        */
        val finalScoresMap = mapOf(
            "AX" to 4, "AY" to 8, "AZ" to 3,
            "BX" to 1, "BY" to 5, "BZ" to 9,
            "CX" to 7, "CY" to 2, "CZ" to 6,
        )

        return input.map { it.replace(" ", "") }
            .sumOf { finalScoresMap[it] ?: 0 }
    }

    fun part2(input: List<String>): Int {
        /*
            A  = ROCK = 1
            B  = PAPER = 2
            C  = SCISSORS = 3

            X = LOSE = 0
            Y = DRAW = 3
            Z = WIN = 6
        */
        val finalScoresMap = mapOf(
            "AX" to 3, "AY" to 4, "AZ" to 8,
            "BX" to 1, "BY" to 5, "BZ" to 9,
            "CX" to 2, "CY" to 6, "CZ" to 7,
        )
        return input.map { it.replace(" ", "") }
            .sumOf { finalScoresMap[it] ?: 0 }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
