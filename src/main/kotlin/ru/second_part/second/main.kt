package ru.second_part.second

// Абстрактный класс Animal с абстрактным методом makeSound()
abstract class Animal {
    abstract fun makeSound()
}

// Подкласс Animal со своей реализацией метода makeSound()
class Tiger : Animal() {
    override fun makeSound() {
        println("Tiger say: AAAAAAAAAAAAAAAAAAAA!")
    }
}

// Подкласс Animal со своей реализацией метода makeSound()
class Lion : Animal() {
    override fun makeSound() {
        println("Lion say: AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA!")
    }
}

// Класс для создания животных с фабричным методом
class AnimalFactory {
    fun createAnimal(animalType: String): Animal? {
        // Переводим строку в нижний регистр и сравниваем
        return when (animalType.lowercase()) {
            "tiger" -> Tiger()
            "lion" -> Lion()
            else -> null
        }
    }
}

fun main() {
    // Создаем объект класса AnimalFactory
    val factory = AnimalFactory()

    // Получаем от пользователя строку с названием животного
    print("Enter the type of animal you want to create (Tiger/Lion): ")
    val animalType = readlnOrNull()

    // Передаем полученную строку в фабричный метод
    val animal = factory.createAnimal(animalType.orEmpty())

    // Если животное было успешно создано, то вызываем метод makeSound()
    if (animal != null)
        animal.makeSound()
    else
        println("No such animal was found")
}
