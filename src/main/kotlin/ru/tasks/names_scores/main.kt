package ru.tasks.names_scores

import java.io.File

fun getLetterNumber(letter: Char): Int {
    return (letter - 'A' + 1)
}

fun main() {
    val input = File("names.txt")
        .readText()
        .split(",")
        .map { it.trim('"') }
        .sorted()

    var sum = 0
    for (i in input.indices) {
        var wordCost = 0
        for (letter in input[i])
            wordCost += getLetterNumber(letter)
        sum += wordCost * (i + 1)
    }
    println(sum)
}

