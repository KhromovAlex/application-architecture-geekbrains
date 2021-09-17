package com.example.applicationarchitecturegeekbrains

interface MainView {
    /**
     * Показывает счетчик №1 на экране по номеру.
     * @param counter новое значение счетчика
     */
    fun showCounter1(counter: String)

    /**
     * Показывает счетчик №2 на экране по номеру.
     * @param counter новое значение счетчика
     */
    fun showCounter2(counter: String)

    /**
     * Показывает счетчик №3 на экране по номеру.
     * @param counter новое значение счетчика
     */
    fun showCounter3(counter: String)
}
