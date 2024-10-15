package ru.second_part.four

// Абстрактный класс со свойством name и абстрактной функцией display
abstract class Component(val name: String) {
    abstract fun display()
}

// Класс CompositeComponent расширяет класс Component
class CompositeComponent(name: String) : Component(name) {
    // Список дочерних компонентов
    private val components = mutableListOf<Component>()

    // Методы для управления компонентами
    fun add(component: Component) {
        components.add(component)
    }

    fun remove(component: Component) {
        components.remove(component)
    }

    // Переопределенная функция display
    override fun display() {
        println("CompositeComponent: $name")    // Отображение имени
        components.forEach { it.display() }     // Вызов функции display на дочерних компонентах
    }
}

// Класс BranchComponent также расширяет класс Component
class BranchComponent(name: String) : Component(name) {
    // Переопределение функции display для отображения имени
    override fun display() {
        println("BranchComponent: $name")
    }
}

fun main() {
    // Создаем экземпляры CompositeComponent
    val headOffice = CompositeComponent("Head Office")
    val region1 = CompositeComponent("Region 1")
    val region2 = CompositeComponent("Region 2")

    // Создаем экземпляры BranchComponent
    val branch1 = BranchComponent("Branch 1")
    val branch2 = BranchComponent("Branch 2")
    val branch3 = BranchComponent("Branch 3")

    // Строим иерархию
    region1.add(branch1)
    region2.add(branch2)
    region2.add(branch3)

    headOffice.add(region1)
    headOffice.add(region2)

    // Выводим иерархию
    headOffice.display()
}