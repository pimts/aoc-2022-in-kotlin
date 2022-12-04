data class Rucksack(val items: String)

fun Rucksack.uniqueItems() = items.toSet()
fun Rucksack.compartment1() = items.substring(startIndex = 0, endIndex = items.length / 2).toSet()
fun Rucksack.compartment2() = items.substring(startIndex = items.length / 2).toSet()

fun Char.priority() =
    if (isLowerCase()) {
        this - 'a' + 1
    } else {
        this - 'A' + 27
    }


fun main() {

    fun part1(input: List<String>): Int {
        return input.map {
            val rucksack = Rucksack(it)
            rucksack.compartment1() intersect rucksack.compartment2()
        }.sumOf { it.single().priority() }
    }

    fun part2(input: List<String>): Int {
        return input.chunked(3) {
            val compartment1 = Rucksack(it[0]).uniqueItems()
            val compartment2 = Rucksack(it[1]).uniqueItems()
            val compartment3 = Rucksack(it[2]).uniqueItems()
            compartment1 intersect compartment2 intersect compartment3
        }.sumOf {
            it.single().priority()
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
