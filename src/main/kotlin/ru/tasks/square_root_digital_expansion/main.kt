package ru.tasks.square_root_digital_expansion

import java.math.BigDecimal
import java.math.MathContext

fun bigDecimalToDigitsArray(number: BigDecimal): CharArray {
    val numberAsString = number.toString()
    return numberAsString.toCharArray()
}

fun main() {
    var sum = 0
    for (i in 1..100) {
        val root = BigDecimal(i).sqrt(MathContext(102))
        if (root.toDouble() % 1.0 != 0.0) {
            val digitsArray = bigDecimalToDigitsArray(root)

            for (j in 0..100)
                if (digitsArray[j].isDigit())
                    sum += digitsArray[j].toString().toInt()
        }
    }
    println(sum)
}

