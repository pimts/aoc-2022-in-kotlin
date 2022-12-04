fun main() {

    fun String.ranges(): Pair<IntRange, IntRange> {
        val (range1Start, range1End) = substringBefore(",").split("-")
        val (range2Start, range2End) = substringAfter(",").split("-")
        return range1Start.toInt()..range1End.toInt() to range2Start.toInt()..range2End.toInt()
    }

    fun part1(input: List<String>): Int {
        return input.map { it.ranges() }
            .count {
                it.first.toSet().containsAll(it.second.toSet()) || it.second.toSet().containsAll(it.first.toSet())
            }
    }

    fun part2(input: List<String>): Int {
        return input.map { it.ranges() }
            .count {
                (it.first.toSet() intersect it.second.toSet()).isNotEmpty()
            }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
