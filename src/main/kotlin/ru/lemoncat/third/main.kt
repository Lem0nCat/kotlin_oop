package ru.lemoncat.third

// Изолированный класс Result с двумя подклассами Success и Error
sealed class Result {
    data class Success(val successMessage: String) : Result()
    data class Error(val errorMessage: String) : Result()
}

// Функция, которая принимает параметр result
fun processResult(result: Result) {
    when (result) { // В зависимости от типа параметра возвращает соответсвующее сообщение
        is Result.Success -> println("Success! Message: '${result.successMessage}'")
        is Result.Error -> println("Error! Message: '${result.errorMessage}'")
    }
}

fun main() {
    // Создание экземпляра Result.Success и Result.Error
    val successResult = Result.Success("Completed in 112 ms")
    val errorResult = Result.Error("Error in input data")

    // Вызов функции для обоих экземпляров
    processResult(successResult)
    processResult(errorResult)
}
