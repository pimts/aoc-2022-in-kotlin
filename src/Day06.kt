fun main() {

    fun String.findStartOfSequenceMarker(sequenceLength: Int) =
        windowed(size = sequenceLength).indexOfFirst { it.length == it.toSet().size } + sequenceLength

    fun String.findStartOfPacketMarker() = findStartOfSequenceMarker(4)

    fun String.findStartOfMessageMarker() = findStartOfSequenceMarker(14)

    fun part1(input: String) = input.findStartOfPacketMarker()

    fun part2(input: String) = input.findStartOfMessageMarker()

    // test if implementation meets criteria from the description, like:
    val testInput = readInputText("Day06_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 19)

    val input = readInputText("Day06")
    println(part1(input))
    println(part2(input))
}
