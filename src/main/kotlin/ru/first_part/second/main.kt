package ru.first_part.second

// Класс с закрытым конструктором
class Logger private constructor() {
    // Метод log() для имитации логирования
    fun log(message: String) {
        println("Log: $message")
    }

    companion object {
        // Ссылка на объект
        private var logger: Logger? = null

        // Функция, которая возвращает ссылку на объект
        fun getInstance(): Logger {
            // Если объекта не существует, то он создается
            if (logger == null)
                logger = Logger()
            return logger as Logger
        }
    }
}

fun main() {
    // Создание двух экземпляров класса
    val logger1 = Logger.getInstance()
    val logger2 = Logger.getInstance()

    // Вызывается метод log на обоих экземплярах для имитации логирования
    logger1.log("Message1")
    logger2.log("Message2")

    // Сравнение ссылок двух экземпляров
    println(logger1 === logger2)
}