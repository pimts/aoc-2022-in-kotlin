import java.util.Stack

data class MoveInstruction(val amount: Int, val from: Int, val to: Int)

fun main() {

    fun parseStacks(input: String): MutableMap<Int, Stack<Char>> {
        val stacks = mutableMapOf<Int, Stack<Char>>()
        val cratesInput = input.substringBefore("\n\n").lines().dropLast(1)
        cratesInput.map { it.windowed(size = 3, step = 4) }
            .forEach {
                it.forEachIndexed { stack, crate ->
                    if (stacks[stack] == null) {
                        stacks[stack] = Stack()
                    }
                    if (crate.isNotBlank()) {
                        stacks[stack]!!.push(crate[1])
                    }
                }
            }
        stacks.values.forEach { it.reverse() }
        return stacks
    }

    fun parseMoves(input: String) =
        input.substringAfter("\n\n").lines()
            .map {
                val (_, amount, _, from, _, to) = it.split(" ")
                MoveInstruction(amount.toInt(), from.toInt() - 1, to.toInt() - 1)
            }

    fun MutableMap<Int,Stack<Char>>.topCrates() = values.fold("") { s, e -> s + e.pop() }

    fun part1(input: String): String {
        val stacks = parseStacks(input)
        val moves = parseMoves(input)
        moves.forEach { (amount, from, to) ->
            repeat(amount) {
                val crate = stacks[from]?.pop()
                stacks[to]?.push(crate)
            }
        }
        return stacks.topCrates()
    }

    fun part2(input: String): String {
        val stacks = parseStacks(input)
        val moves = parseMoves(input)
        moves.forEach { (amount, from, to) ->
            var substack = ""
            repeat(amount) {
                substack = stacks[from]?.pop()!!  + substack
            }
            substack.forEach { stacks[to]?.push(it) }
        }
        return stacks.topCrates()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputText("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInputText("Day05")
    println(part1(input))
    println(part2(input))
}

private operator fun <E> List<E>.component6(): E {
    return this[5]
}
