package ru.second_part.third

// Интерфейс с наблюдателем
interface Observer {
    fun update(message: String)
}

// Интерфейс Observable, в котором определены методы subscribe и unsubscribe
interface Observable {
    fun subscribe(observer: Observer)
    fun unsubscribe(observer: Observer)
}

// Publisher реализует интерфейс Observable
class Publisher : Observable {
    // Список наблюдателей
    private val observers = mutableListOf<Observer>()

    // Переопределеный метод subscribe
    override fun subscribe(observer: Observer) {
        observers.add(observer)
    }

    // Переопределеный метод unsubscribe
    override fun unsubscribe(observer: Observer) {
        observers.remove(observer)
    }

    // Метод для отправки сообщения всем подписанным наблюдателям
    fun publishMessage(message: String) {
        observers.forEach { it.update(message) }
    }
}

// Класс оповещений по почте
class EmailNotification : Observer {
    override fun update(message: String) {
        println("Sending email notification: $message")
    }
}

// Класс оповещений по СМС
class SMSNotification : Observer {
    override fun update(message: String) {
        println("Sending SMS notification: $message")
    }
}

fun main() {
    // Создаем объекты классов
    val publisher = Publisher()
    val emailNotification = EmailNotification()
    val smsNotification = SMSNotification()

    // Подписываем наблюдателя на оповещения по СМС и почте
    publisher.subscribe(emailNotification)
    publisher.subscribe(smsNotification)

    // Отправляем сообщение, наблюдатель получает сообщение по СМС и почте
    publisher.publishMessage("New video!")

    // Отписываем наблюдателя от оповещении по почте
    publisher.unsubscribe(emailNotification)

    // Отправляем сообщение, наблюдатель получаем сообщение только по СМС
    publisher.publishMessage("One more video!")
}
