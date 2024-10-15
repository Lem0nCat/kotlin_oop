package ru.first_part.first

import kotlin.math.PI
import kotlin.math.sqrt

// Константы с максимальным значением параметров фигур (радиус, сторона фигур, ...)
const val paramMaxValue = 10
const val shapesCount = 10

// Абстрактный класс с двумя методами
abstract class Shape {
    abstract fun area(): Double
    abstract fun perimeter(): Double
}

// Класс Circle наследуется от класса Shape и имеет переопределенный метод area() и perimeter()
class Circle : Shape() {
    var radius: Int = 0 // Свойство с радиусом круга

    init {  // Случайное значение радиуса при инициализации объекта класса
        radius = (1..paramMaxValue).random()
    }

    override fun area(): Double {
        return PI * (radius * radius)
    }

    override fun perimeter(): Double {
        return 2 * PI * radius
    }
}

// Класс Rectangle наследуется от класса Shape и имеет переопределенный метод area() и perimeter()
class Rectangle : Shape() {
    var width: Int = 0  // Ширина
    var height: Int = 0 // Высота

    init {  // Случайные значения свойств при инициализации объекта класса
        width = (1..paramMaxValue).random()
        height = (1..paramMaxValue).random()
    }

    override fun area(): Double {
        return (width * height).toDouble()
    }

    override fun perimeter(): Double {
        return (width * 2 + height * 2).toDouble()
    }
}

// Класс Triangle наследуется от класса Shape и имеет переопределенный метод area() и perimeter()
class Triangle : Shape() {
    var sideA: Int = 0  // Первая сторона треугольника
    var sideB: Int = 0 // Вторая сторона треугольника
    var sideC: Int = 0  // Третья сторона треугольника

    init {  // Цикл, который случайно выбирает значения сторон и проверяет их на условие существования треугольника
        while (!(sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA)) {
            sideA = (1..paramMaxValue).random()
            sideB = (1..paramMaxValue).random()
            sideC = (1..paramMaxValue).random()
        }
    }

    override fun area(): Double {
        val p: Double = (sideA + sideB + sideC).toDouble() / 2
        val result = p * (p - sideA) * (p - sideB) * (p - sideC)
        return sqrt(result)
    }

    override fun perimeter(): Double {
        return (sideA + sideB + sideC).toDouble()
    }
}

fun main() {
    // Создание трех списков с фигурами
    val circles = MutableList(shapesCount) { Circle() }
    val rectangles = MutableList(shapesCount) { Rectangle() }
    val triangles = MutableList(shapesCount) { Triangle() }


    // Вывод всех фигур и подсчитанных значений
    circles.forEach {
        println("Circle || R = ${it.radius} | Area = ${it.area()} | Perimeter = ${it.perimeter()}")
    }
    println()
    rectangles.forEach {
        println("Rectangle || Width = ${it.width} | Height = ${it.height} | Area = ${it.area()} | Perimeter = ${it.perimeter()}")
    }
    println()
    triangles.forEach {
        println("Triangle || First side = ${it.sideA} | Second side = ${it.sideB} | Third side = ${it.sideC} | Area = ${it.area()} | Perimeter = ${it.perimeter()}")
    }
}