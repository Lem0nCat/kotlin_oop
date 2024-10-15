package ru.tasks.w_1001st_prime


fun main() {
    val primeNumbers = hashSetOf(2)
    var count = 1

    var i = 3
    while (count < 10001) {
        if (!primeNumbers.any { i % it == 0 }) {
            primeNumbers.add(i)
            count++
        }
        i++
    }
    println(primeNumbers.max())
}

