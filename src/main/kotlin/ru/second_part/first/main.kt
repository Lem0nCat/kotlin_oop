package ru.second_part.first

// Интерфейс Component
interface Component {
    fun render(): String
}

// Основной компонент
class MainComponent : Component {
    override fun render(): String {
        return "test"
    }
}

// Абстрактный класс TextDecorator, реализующий интерфейс Component
abstract class TextDecorator(private val component: Component) : Component {
    override fun render(): String {
        return component.render()
    }
}

// Конкретный декоратор BoldDecorator
class BoldDecorator(component: Component) : TextDecorator(component) {
    override fun render(): String {
        return "<b>${super.render()}</b>"
    }
}

// Конкретный декоратор ItalicDecorator
class ItalicDecorator(component: Component) : TextDecorator(component) {
    override fun render(): String {
        return "<i>${super.render()}</i>"
    }
}

fun main() {
    // Создаем иссходный компонент
    val mainComponent = MainComponent()

    // Создаем BoldDecorator и оборачиваем mainComponent
    val boldDecorator = BoldDecorator(mainComponent)

    // Создаем декоратор ItalicDecorator и оборачиваем им компонент с BoldDecorator
    val boldItalicDecorator = ItalicDecorator(boldDecorator)

    // Выводим результаты
    println("Main Component: ${mainComponent.render()}")
    println("Bold Decorator: ${boldDecorator.render()}")
    println("Bold Italic Decorator: ${boldItalicDecorator.render()}")
}
