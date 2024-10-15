package ru.tasks.sum_square_diff

fun main() {
    val squaresSum = (1..100).sumOf { it * it }
    val squareOfSum = (1..100).sum() * (1..100).sum()
    println(squareOfSum - squaresSum)
}

